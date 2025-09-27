class LC0701 {
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
		public TreeNode insertIntoBST(TreeNode node, int val) {
			if (node == null) {
				return new TreeNode(val);
			}
			if (node.val > val) {
				node.left = insertIntoBST(node.left, val);
				return node;
			}

			if (node.val < val) {
				node.right = insertIntoBST(node.right, val);
				return node;
			}
			return node;
		}
	}
}
