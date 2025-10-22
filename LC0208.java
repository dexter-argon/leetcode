import java.util.*;

class LC0208 {
	class Trie {

		static class TrieNode {
			Map<Character, TrieNode> children;
			boolean isEnd = false;

			public TrieNode() {
				this.children = new HashMap<>();
				this.isEnd = false;
			}
		}

		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode node = root;
			for (var c : word.toCharArray()) {
				if (!node.children.containsKey(c)) {
					node.children.put(c, new TrieNode());
				}
				node = node.children.get(c);
			}
			node.isEnd = true;
		}

		public boolean search(String word) {
			TrieNode node = root;
			for (var c : word.toCharArray()) {
				if (!node.children.containsKey(c)) {
					return false;
				}
				node = node.children.get(c);
			}
			return node.isEnd;
		}

		public boolean startsWith(String prefix) {
			TrieNode node = root;
			for (var c : prefix.toCharArray()) {
				if (!node.children.containsKey(c)) {
					return false;
				}
				node = node.children.get(c);
			}
			return true;
		}
	}

}
