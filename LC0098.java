class LC0098 {

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
		public boolean isValidBST(TreeNode root) {
			return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
		}

		private boolean isBST(TreeNode node, long minValue, long maxValue) {
			if (node == null) {
				return true;
			}
			if (node.val <= minValue || node.val >= maxValue) {
				return false;
			}

			boolean isLeftSubtreeBST = isBST(node.left, minValue, node.val);
			boolean isRightSubtreeBST = isBST(node.right, node.val, maxValue);

			return isLeftSubtreeBST && isRightSubtreeBST;
		}
	}
}
