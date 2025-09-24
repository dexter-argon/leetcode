import java.util.*;

public class LC0144 {
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
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> preorderTraversal = new ArrayList<>();

			if (root == null) {
				return preorderTraversal;
			}
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);

			while(!stack.isEmpty()) {
				// no need of visited set
				TreeNode node = stack.pop();
				preorderTraversal.add(node.val);
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}

			return preorderTraversal;
		}

	}	
}
