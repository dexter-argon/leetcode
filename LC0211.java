class LC0211 {
	class WordDictionary {

		static class TrieNode {
			TrieNode[] children;
			boolean isEnd;

			public TrieNode() {
				this.children = new TrieNode[26];
				this.isEnd = false;
			}
		}

		private TrieNode root = null;

		public WordDictionary() {
			this.root = new TrieNode();
		}

		public void addWord(String word) {
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

		public boolean search(String word) {
			return searchHelper(word, root);
		}

		private boolean matchDotWildcard(TrieNode node, String word) {
			for (var child : node.children) {
				if (child == null) {
					continue;
				}
				if (searchHelper(word, child)) {
					return true;
				}
			}
			return false;
		}

		private boolean searchHelper(String word, TrieNode node) {
			if (word.isEmpty()) {
				return node.isEnd;
			}
			for (var i = 0; i < word.length(); i += 1) {
				char c = word.charAt(i);
				if (c == '.') {
					return matchDotWildcard(node, word.substring(i + 1));
				}
				var idx = (int) (c - 'a');
				if (node.children[idx] == null) {
					return false;
				}
				node = node.children[idx];
			}
			return node.isEnd;
		}

	}

}
