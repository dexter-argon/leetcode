import java.util.*;

/*
 * In Datadog, the live tail feature allows users to view logs in real-time, as
 * they are being generated. It also allows you to match logs based on a query.
 * You can enter specific search terms, and the live tail will only display the
 * logs that match these criteria. The input list contains strings that start
 * with either "Q:" or "L:". The live tail will need to match logs to previous
 * queries. Queries are prefixed with "Q: ", and consist of a case insensitive
 * list of words which must all match. Logs are prefixed with "L: ".
 */
class Solution {
	static List<String> livetailStream = List.of(
			"Q: database",
			"Q: Stacktrace",
			"Q: loading failed",
			"L: Database service started",
			"Q: snapshot loading",
			"Q: fail",
			"L: Started processing events",
			"L: Loading main DB snapshot",
			"L: Loading snapshot failed no stacktrace available");
	/*
	 * The live tail outputs a list containing strings that start with either “ACK:”
	 * or “M:”. “ACK:” represents an acknowledgment of a query. Queries are given
	 * unique IDs. “M:” represents a response with successful matches. These
	 * indicate which query IDs matched the given log. Given the input above, the
	 * expected output should be similar to the following:
	 *
	 *
	 */
	static List<String> livetailOutput = List.of(
			"ACK: database; ID=1",
			"ACK: Stacktrace; ID=2",
			"ACK: loading failed; ID=3",
			"M: Database service started; Q=1",
			"ACK: snapshot loading; ID=4",
			"ACK: fail; ID=5",
			"M: Loading main DB snapshot; Q=4",
			"M: Loading snapshot failed no stacktrace available; Q=2,3,4");

	static String LOG = "L:";
	static String QUERY = "Q:";
	static String ACK = "ACK:";
	static String MATCHES = "M:";

	private static Set<String> buildDictionary(String[] words) {
		Set<String> dict = new HashSet<>();
		for (int i = 1; i < words.length; i += 1) {
			dict.add(words[i].toLowerCase());
		}
		return dict;
	}

	public static List<String> queryRetrieve(List<String> queries) {
		List<String> result = new ArrayList<>();
		List<List<String>> insertedEntries = new ArrayList<>();
		for (var query : queries) {
			String[] words = query.split(" ");
			String queryType = words[0];
			if (queryType.equals(LOG)) {
				// search the query
				Set<String> qDictionary = buildDictionary(words);
				String matchedIds = "";
				for (int i = 0; i < insertedEntries.size(); i++) {
					int id = i + 1;
					List<String> searchPhrase = insertedEntries.get(i);
					int matchesCount = 0;
					for (int j = 0; j < searchPhrase.size(); ++j) {
						if (qDictionary.contains(searchPhrase.get(j))) {
							matchesCount += 1;
						} else {
							break;
						}
					}
					if (matchesCount == searchPhrase.size()) {
						matchedIds += id + ",";
					}
				}
				if (!matchedIds.equals("")) {
					// there is atleast a match
					result.add(MATCHES + " " + query + "; Q=" + matchedIds);
				}
			} else if (queryType.equals(QUERY)) {
				// insert in the data store
				List<String> phrase = new ArrayList<>();
				for (int i = 1; i < words.length; i++) {
					phrase.add(words[i].toLowerCase());
				}
				insertedEntries.add(phrase);
				result.add(ACK + " " + query + "; ID=" + insertedEntries.size());
			}
		}
		return result;
	}

	/*
	 * search: "q1, q2, q3"
	 * insert: "w1, w2, w3" id = 12
	 * w1 => [12]
	 * w2 => [12]
	 * w3 => [12]
	 *
	 */

	public static void main(String[] args) {
		var res = queryRetrieve(livetailStream);
		for (var out : res) {
			System.out.println(out);
		}
	}
}
