import java.util.*;

class LC0105 {

	/**
	 * Definition for a binary tree node.
	 */
	static public class TreeNode {
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

	static class Solution {
		Map<Integer, Integer> inorderTraversalMap = new HashMap<>();

		public TreeNode buildTree(int[] preorder, int[] inorder) {

			for (int i = 0; i < inorder.length; i++) {
				inorderTraversalMap.put(inorder[i], i);
			}

			return buildBinaryTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
		}

		private int findNodeInInorderTraversal(int[] inorder, int target) {
			return inorderTraversalMap.getOrDefault(target, -1);
		}

		private TreeNode buildBinaryTree(
				int[] preorder,
				int[] inorder,
				int pStartIndex,
				int pEndIndex,
				int iStartIndex,
				int iEndIndex) {

			// Guard Conditions
			if (pStartIndex == pEndIndex) {
				return new TreeNode(preorder[pStartIndex]);
			}

			if (pStartIndex > pEndIndex) {
				return null;
			}

			// Root node
			TreeNode node = new TreeNode(preorder[pStartIndex]);

			// Find the index of node in inorder traversal
			int nodeIndex = findNodeInInorderTraversal(inorder, node.val);

			int leftCount = nodeIndex - iStartIndex;

			// Left Subtree
			node.left = buildBinaryTree(preorder, inorder, pStartIndex + 1, pStartIndex + leftCount, iStartIndex,
					nodeIndex - 1);

			// Right Subtree
			node.right = buildBinaryTree(preorder, inorder, pStartIndex + leftCount + 1, pEndIndex, nodeIndex + 1,
					iEndIndex);

			return node;
		}
	}

}
