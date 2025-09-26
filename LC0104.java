
class LC0104 {

	static public class TreeNode {
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
		public int maxDepth(TreeNode node) {
			if (node == null) {
				return 0;
			}

			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);

			return 1 + Math.max(leftDepth, rightDepth);
		}
	}

}
