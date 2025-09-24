import java.util.*;

public class LC0094 {
	
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

	// Using Stack
	List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorderTraversal = new ArrayList<>();
		if (root == null) {
			return inorderTraversal;
		}

		Stack<TreeNode> stack = new Stack<>();
		Set<TreeNode> visitedNodes = new HashSet<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if(node.left != null && !visitedNodes.contains(node.left)) {
				stack.push(node.left);
				continue;
			} 
			stack.pop();
			visitedNodes.add(node);
			inorderTraversal.add(node.val);
			if (node.right != null) {
				if (!visitedNodes.contains(node.right)) { // I think we don't need this IF
					stack.push(node.right);
				}
			} 			
		}

		return inorderTraversal;
	}


}
