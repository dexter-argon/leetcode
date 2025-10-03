class LC0124 {
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
		int maxPathSum = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode node) {
			maxPathSumHelper(node);
			return this.maxPathSum;
		}

		private int maxPathSumHelper(TreeNode node) {
			// num of nodes is 10^4 and max node value is 10^3.
			// So, there is no need for long values for storing accumulated sum.
			if (node == null) {
				return 0;
			}

			int leftSubtree = Math.max(maxPathSumHelper(node.left), 0);
			int rightSubtree = Math.max(maxPathSumHelper(node.right), 0);

			// check max path is current node all by itself or
			// leftSubtree + rightSubtree + node
			int maxPath = leftSubtree + rightSubtree + node.val;

			this.maxPathSum = Math.max(this.maxPathSum, maxPath);

			return node.val + Math.max(leftSubtree, rightSubtree);
		}
	}
}
