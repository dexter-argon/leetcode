class LC0572 {
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

		public boolean isSubtree(TreeNode root, TreeNode subRoot) {
			if (root == null && subRoot == null) {
				return true;
			}
			if (root == null || subRoot == null) {
				return false;
			}
			if (isSameTree(root, subRoot)) {
				return true;
			}

			if (isSubtree(root.left, subRoot)) {
				return true;
			}

			if (isSubtree(root.right, subRoot)) {
				return true;
			}

			return false;
		}
	}

}
