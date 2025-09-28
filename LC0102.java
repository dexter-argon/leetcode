import java.util.*;

class LC0102 {

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

	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null) {
				return new ArrayList<>();
			}

			Queue<TreeNode> q = new LinkedList<TreeNode>();
			List<List<Integer>> levelOrderTraversal = new ArrayList<>();

			q.add(root);

			while (!q.isEmpty()) {
				int levelSize = q.size();
				List<Integer> levelNodes = new ArrayList<Integer>();

				for (int nodeIdx = 0; nodeIdx < levelSize; nodeIdx++) {
					TreeNode currNode = q.poll();

					if (currNode.left != null) {
						q.add(currNode.left);
					}

					if (currNode.right != null) {
						q.add(currNode.right);
					}

					// visiting this node
					levelNodes.add(currNode.val);
				}
				levelOrderTraversal.add(levelNodes);
			}

			return levelOrderTraversal;
		}
	}
}
