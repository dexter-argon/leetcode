import java.util.*;

public class ConfluentR2 {

	public static class Pair {
		int documentId;
		int index;

		public Pair(int documentId, int index) {
			this.documentId = documentId;
			this.index = index;
		}
	}

	HashMap<String, List<Pair>> wordToDocumentsMap;
	List<String[]> documentsWordList;

	private void processDocuments(List<String> documents) {
		int documentId = 0;
		for (var document : documents) {
			// no continue;
			// Split the document into array of words
			String[] words = document.split(" ");
			for (var i = 0; i < words.length; i += 1) {
				String word = words[i];
				wordToDocumentsMap.putIfAbsent(word, new ArrayList<>());
				Pair pair = new Pair(documentId, i);
				wordToDocumentsMap.get(word).add(pair);
			}
			this.documentsWordList.add(words);

			documentId += 1;
		}

	}

	private boolean isWordInDocument(int documentId, int index, String word) {
		String[] wordsOfDocument = this.documentsWordList.get(documentId);
		if (index >= wordsOfDocument.length) {
			return false;
		}
		return wordsOfDocument[index].equals(word);
	}

	public List<Integer> findDocumentsWithGivenPhrase(List<String> documents, String phrase) {
		if (phrase.isEmpty()) {
			return List.of();
		}
		Set<Integer> documentIdList = new HashSet<>();
		processDocuments(documents);

		var words = phrase.split(" ");
		if (!wordToDocumentsMap.containsKey(words[0])) {
			return List.of();
		}

		List<Pair> documentWithWord = new ArrayList<>(wordToDocumentsMap.get(words[0]));
		List<Pair> updatedDocumentWithWord = new ArrayList<>();

		for (int i = 1; i < words.length; i += 1) {
			var word = words[i];
			for (var pair : documentWithWord) {
				int documentId = pair.documentId;
				int index = pair.index;
				if (isWordInDocument(documentId, index + 1, word)) {
					updatedDocumentWithWord.add(new Pair(documentId, index + 1));
				}
			}
			documentWithWord = new ArrayList<>(updatedDocumentWithWord);
			updatedDocumentWithWord.clear();
		}

		for (var pair : documentWithWord) {
			documentIdList.add(pair.documentId);
		}

		return new ArrayList<>(documentIdList);
	}

	public ConfluentR2() {
		this.wordToDocumentsMap = new HashMap<>();
		this.documentsWordList = new ArrayList<>();
	}

	public static void main(String[] args) {

		List<String> documents = List.of("I am a good programmer", "Being good isn't a virtue",
				"Life is not good enough");
		String phrase = "good i";

		ConfluentR2 con = new ConfluentR2();
		List<Integer> documentIds = con.findDocumentsWithGivenPhrase(documents, phrase);

		if (documentIds.isEmpty()) {
			System.out.println("No document found with given phrase");
		}

		for (var i = 0; i < documentIds.size(); i++) {
			System.out.println("documentId: " + documentIds.get(i));
		}

	}

}
