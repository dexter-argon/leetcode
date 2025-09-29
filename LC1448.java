class LC1448 {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static class Solution {
		/*
		 * @param: root of an Binary Tree (Not BST)
		 */
		public int goodNodes(TreeNode root) {
			return countGoodNodes(root, Integer.MIN_VALUE);
		}

		public int countGoodNodes(TreeNode node, int maxNodeValueSeenSoFar) {
			if (node == null) {
				return 0;
			}
			maxNodeValueSeenSoFar = Math.max(maxNodeValueSeenSoFar, node.val);

			int leftGoodNodes = countGoodNodes(node.left, maxNodeValueSeenSoFar);
			int rightGoodNodes = countGoodNodes(node.right, maxNodeValueSeenSoFar);

			return leftGoodNodes + rightGoodNodes + ((maxNodeValueSeenSoFar == node.val) ? 1 : 0);
		}
	}
}
