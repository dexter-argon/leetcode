import java.util.*;

public class LC0145 {
	
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

	static public class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			if (root == null) {
				return new ArrayList<Integer>();
			}

			var postorderTraversal = new ArrayList<Integer>();
			Stack<TreeNode> stack = new Stack<>();
			var visitedNodes = new HashSet<TreeNode>();
			stack.push(root);

			while (!stack.isEmpty()) {
				var node = stack.peek();

				if (node.right != null && !visitedNodes.contains(node.right)) {
					stack.push(node.right);
					if (node.left == null) {
						continue;
					}
				}
				if (node.left != null && !visitedNodes.contains(node.left)) {
					stack.push(node.left);
					continue;
				}
				stack.pop();
				visitedNodes.add(node);
				postorderTraversal.add(node.val);
			}

			return postorderTraversal;
    	}
	}
}
