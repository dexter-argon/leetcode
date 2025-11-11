class LC2707 {
	class Solution {

		static class TrieNode {
			TrieNode[] children;
			boolean isEnd;

			public TrieNode() {
				this.children = new TrieNode[26];
				this.isEnd = false;
			}
		}

		TrieNode root;

		public Solution() {
			this.root = new TrieNode();
		}

		private void addWordToTrie(String word) {
			TrieNode node = root;
			for (var c : word.toCharArray()) {
				var idx = (int) (c - 'a');
				if (node.children[idx] == null) {
					node.children[idx] = new TrieNode();
				}
				node = node.children[idx];
			}
			node.isEnd = true;
		}

		private void buildTrie(String[] dictionary) {
			for (var word : dictionary) {
				addWordToTrie(word);
			}
		}

		public int minExtraChar(String s, String[] dictionary) {
			buildTrie(dictionary);

			helper(s);

			return 0;

		private int matchFirstPrefix(String s) {
			TrieNode node = root;
			int i = 0;
			for (var c : s.toCharArray()) {
				var idx = (int) (c - 'a');
				if (node.children[idx] == null) {
					return -1;
				}
				node = node.children[idx];
				if (node.isEnd) {
					return i;
				}
				++i;
			}
			return node.isEnd ? s.length() - 1 : -1;
		}

		private int helper(String s) {
			int idx = 0;
			var deletedChars = 0;

			while (idx < s.length()) {
				int matchIdx = matchFirstPrefix(s.substring(idx));
				if (matchIdx == -1) {
					// no match in dictionary.
					++deletedChars;
				} else {
					// there is a match.
					helper(s.substring(matchIdx + 1));
				}
			}
			return 0;
		}

	}
}
