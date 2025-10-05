class LC0297 {
	/**
	 * Definition for a binary tree node.
	 */
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static class Codec {

		private final String NULL = ":";
		private final String SEPARATOR = ",";

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) {
				return "";
			}
			StringBuilder sb = new StringBuilder();
			// How to encode a Binary Tree?
			// level order traversal

			serializeHelper(root, sb);

			return sb.toString();
		}

		// ":" denotes
		private void serializeHelper(TreeNode node, StringBuilder sb) {
			// Preorder traversal
			if (node == null && sb.isEmpty()) {
				sb.append(NULL);
				return;
			} else if (node == null && !sb.isEmpty()) {
				sb.append(SEPARATOR + NULL);
				return;
			} else if (sb.isEmpty()) {
				sb.append(node.val);
			} else {
				sb.append(SEPARATOR + node.val);
			}

			serializeHelper(node.left, sb);
			serializeHelper(node.right, sb);
		}

		int deserialisingIdx = 0;

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.isEmpty()) {
				return null;
			}

			String[] nodes = data.split(SEPARATOR);

			return deserializeHelper(nodes);
		}

		private TreeNode deserializeHelper(String[] nodes) {
			if (nodes[deserialisingIdx].equals(NULL)) {
				++deserialisingIdx;
				return null;
			}
			TreeNode node = new TreeNode(Integer.parseInt(nodes[deserialisingIdx++]));

			node.left = deserializeHelper(nodes);
			node.right = deserializeHelper(nodes);

			return node;
		}
	}
}
