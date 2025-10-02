import java.util.*;

class LC0337 {

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

		public int rob(TreeNode node) {
			if (node == null) {
				return 0;
			}

			// you can't rob node and it's direct children as that would alert
			// the police.
			// Robber has two option while on a node.
			// 1. rob the current node/house, and then rob node.left.[left/right] or
			// node.right.[left/right]
			// 2. leave this house and rob move on to the node left and right children
			// recursively

			int[] ans = robHelper(node);

			return Math.max(ans[0], ans[1]);
		}

		private int[] robHelper(TreeNode node) {
			if (node == null) {
				return new int[] { 0, 0 };
			}
			int[] left = robHelper(node.left);
			int[] right = robHelper(node.right);

			int notRobbed = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
			int robbed = node.val + left[1] + right[1];

			return new int[] { robbed, notRobbed };
		}
	}
}
