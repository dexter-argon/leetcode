public class LC0100 {

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
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if (p == null && q == null) {
				return true;
			}
			if (p == null || q == null) {
				return false;
			}

			if (p.val != q.val) {
				return false;
			}
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}
