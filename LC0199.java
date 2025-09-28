import java.util.*;

class LC0199 {
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
		/**
		 *
		 * @return: List<Integer> which is right view of the tree
		 * @time: O(n) visit every node once
		 * @space: O(l) recursiion stack space and number of levels
		 *
		 *         At every level we would have only one node.
		 *         visit right child first and insert the values, if for a depth no node
		 *         is present use the current node
		 */
		public List<Integer> rightSideView(TreeNode root) {
			Map<Integer, Integer> rightViewMap = new LinkedHashMap<>();
			rightViewTraversal(root, rightViewMap, 0);

			List<Integer> rightView = new ArrayList<>(rightViewMap.size());

			for (Map.Entry<Integer, Integer> entry : rightViewMap.entrySet()) {
				rightView.add(entry.getValue());
			}

			return rightView;
		}

		private void rightViewTraversal(TreeNode node, Map<Integer, Integer> rightView, int level) {
			if (node == null) {
				return;
			}

			if (!rightView.containsKey(level)) {
				rightView.put(level, node.val);
			}

			rightViewTraversal(node.right, rightView, level + 1);
			rightViewTraversal(node.left, rightView, level + 1);
		}
	}

}
