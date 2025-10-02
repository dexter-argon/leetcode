class LC1325 {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
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

	class Solution {
		// Delete leaf nodes with values target.
		// However, node can become leaf while deletion.
		// If that node happens to met the criterion then do the deletion.
		public TreeNode removeLeafNodes(TreeNode node, int target) {
			if (node == null) {
				return null;
			}

			node.left = removeLeafNodes(node.left, target);
			node.right = removeLeafNodes(node.right, target);

			if (isLeaf(node) && (node.val == target)) {
				// deleting the node, by removing reference to this node.
				// GC will take care of deletion.
				return null;
			}

			return node;
		}

		private boolean isLeaf(TreeNode node) {
			if (node == null)
				return false;

			return (node.left == null) && (node.right == null);
		}
	}
}
