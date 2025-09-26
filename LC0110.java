class LC0110 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	static public class Solution {
		public boolean isBalanced(TreeNode root) {
			boolean[] ans = new boolean[] { true };
			return checkHeight(root, ans) > -1;

		}

		public int checkHeight(TreeNode node, boolean[] ans) {
			if (node == null) {
				return 0;
			}
			int leftDepth = checkHeight(node.left, ans);
			if (leftDepth == -1) {
				return -1;
			}
			int rightDepth = checkHeight(node.right, ans);
			if (rightDepth == -1) {
				return -1;
			}

			if (Math.abs(leftDepth - rightDepth) > 1) {
				return -1;
			}

			return 1 + Math.max(leftDepth, rightDepth);
		}
	}
}
