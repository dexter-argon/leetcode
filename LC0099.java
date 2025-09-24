import java.util.*;

public class LC0099 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
  	}
	// You are given the root of a binary search tree (BST), 
	// where the values of exactly two nodes of the tree were swapped by mistake. 
	// Recover the tree without changing its structure.
	public static class Solution {
		List<TreeNode> inorderTraversal = new ArrayList<>();
		/*
		 * @param root of the modified BST
		 * @return nothing, fix the given BST
		 */
		public void recoverTree(TreeNode root) {
			inorder(root);
			TreeNode firstSwappedNode = null, secondSwappedNode = null;
			for (int i = 0; (i + 1) < this.inorderTraversal.size(); i += 1) {
				TreeNode node = this.inorderTraversal.get(i);
				TreeNode nextNode = inorderTraversal.get(i+1);
				if (node.val > nextNode.val) {
					if (firstSwappedNode == null) {
						firstSwappedNode = node;
					}
					secondSwappedNode = nextNode;
				}

			}

			int secondNodeVal = secondSwappedNode.val;
			secondSwappedNode.val = firstSwappedNode.val;
			firstSwappedNode.val = secondNodeVal;
			return;
		}

		private void inorder(TreeNode node) {
			// base condition
			if (node == null) {
				return;
			}

			inorder(node.left);
			this.inorderTraversal.add(node);
			inorder(node.right);
		}
	}
	
}
