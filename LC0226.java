import java.util.*;

public class LC0226 {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	static public class Solution {

		public TreeNode invertTree(TreeNode node) {
			if (node == null) {
				return null;
			}

			TreeNode rightNode = node.right;
			node.right = node.left;
			node.left = rightNode;

			invertTree(node.left);
			invertTree(node.right);

			return node;
		}

	}
}
