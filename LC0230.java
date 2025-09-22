
class LC0230 {

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

	static class Pair {
		int rank;
		int result;

		Pair(int rank, int result) {
			this.rank = rank;
			this.result = result;
		}
	}

	static public class Solution {
		// O(nlgn) solution would be to sort the element and get the kth element from beginning as Tree is BST
		int count = 0;
		int result = 0;
		public int kthSmallest(TreeNode root, int k) {
			// int result = 0;
			// traverse to the leftmost node give it number 1
			// then do inorder traversal
			// How do we pass the rank of the node to the next.
			// and how do we return the node if we have found the solution.
			
			// return inorderWithRank(root, 0, k).result;
			inorder(root, k);
			return this.result;
		}

		public void inorder(TreeNode node, int k) {
			if (node == null || count >= k) {
				return;
			}

			inorder(node.left, k);

			if (++this.count == k) {
				result = node.val;
				return;
			}

			inorder(node.right, k);
		}

		public Pair inorderWithRank(TreeNode node, int ancestorRank, int k) {
			if (node == null) {
				return new Pair(0, -1);
			}
			
			int nodeRank;
			Pair leftPair = null;
			if (node.left == null) {
				nodeRank = ancestorRank + 1;
			} else {
				leftPair = inorderWithRank(node.left, ancestorRank, k);
				nodeRank = leftPair.rank + 1;
			}

			if (nodeRank == k) {
				return new Pair(nodeRank, node.val);	
			}
			if (leftPair != null && leftPair.result != -1) {
				return leftPair;
			}

			if (node.right == null) {
				return new Pair(nodeRank, -1);
			}

			var maxRankRighSubtreeNode = inorderWithRank(node.right, nodeRank, k);
			return maxRankRighSubtreeNode;
		}

	}

	public static void main(String[] args) {
		Solution sol = new Solution();

		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(13);
		root.right = new TreeNode(18);
		root.left.left = new TreeNode(12);
		root.left.right = new TreeNode(14);
		root.left.left.left = new TreeNode(11);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(21);
		root.right.right.right = new TreeNode(28);
		root.right.right.right.right = new TreeNode(29);

		System.out.println(sol.kthSmallest(root, 3));
		System.out.println(sol.kthSmallest(root, 6));
	}
}