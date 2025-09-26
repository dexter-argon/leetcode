// import java.util.*;

public class LC0543 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this(val, null, null);
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static public class Solution {

		public int diameterOfBinaryTree(TreeNode root) {
			int[] diameter = new int[1];
			diameterOfBinaryTreeHelper(root, diameter);
			return diameter[0];
		}

		private int diameterOfBinaryTreeHelper(TreeNode node, int[] diameter) {
			// return height of the tree, but update the diameter if greater
			if (node == null) {
				return 0;
			}

			int leftHeight = diameterOfBinaryTreeHelper(node.left, diameter);
			int rightHeight = diameterOfBinaryTreeHelper(node.right, diameter);

			diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
			// this counts the numberOfNodes - 1 which is the number of edges

			return 1 + Math.max(leftHeight, rightHeight);
		}
	}
}
