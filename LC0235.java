
class LC0235 {
	static public class Solution {
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


		TreeNode lca = null;

		public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
			// lowestCommonAncestorHelper(root, p, q);
			if (root.val < p.val && root.val < q.val) {
				return lowestCommonAncestor(root.left, p, q);
			}
			if (root.val > p.val && root.val > q.val) {
				return lowestCommonAncestor(root.right, p, q);
			}

			return root;
		}

		public int lowestCommonAncestorHelper (TreeNode node, TreeNode p, TreeNode q) {
			if (node == null) { // base case
				return 0;
			}
			// node is equal to either p or q
			// left, self, right sum should be >= 2 for node to be lca
			int self = ((node == p) || (node == q)) ? 1 : 0;

			int nodeFoundInLeftSubtree = 0, nodeFoundInRightSubtree = 0;

			if (node.val > p.val || node.val > q.val) {
				nodeFoundInLeftSubtree = lowestCommonAncestorHelper(node.left, p, q);
			} 
			if (node.val < p.val || node.val < q.val) {
				nodeFoundInRightSubtree = lowestCommonAncestorHelper(node.right, p, q);
			}

			if ((self + nodeFoundInLeftSubtree + nodeFoundInRightSubtree) >= 2) {
				this.lca = node;
			}

			return ((self + nodeFoundInLeftSubtree + nodeFoundInRightSubtree) >= 1) ? 1 : 0;
		}



	}


}
