class LC0450 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	static class Pair {
		TreeNode node;
		int succVal;

		Pair(TreeNode child, int succVal) {
			this.node = child;
			this.succVal = succVal;
		}
	}

	static public class Solution {
		static class Pair {
			TreeNode node;
			int succVal;

			Pair(TreeNode child, int succVal) {
				this.node = child;
				this.succVal = succVal;
			}
		}

		public TreeNode deleteNode(TreeNode node, int key) {
			// First, search the node, if not found nothing
			// else, deleting a node is equal to replacing it with inorder successor
			// and, then deleting the swapped node.
			if (node == null) {
				return null;
			}

			if (node.val == key) {
				// System.out.println("key is found");
				// found the node
				// 1. leaft node, then return null
				// 2. one child, if left child then return child reference, if right child
				// inorderSuccessor(node);
				// 3. two children, same as right child case.
				if (node.right == null && node.left == null) {
					return null;
				}
				if (node.right == null) {
					return node.left;
				}
				if (node.right != null) {
					var pair = inorderSuccessor(node.right);
					node.right = pair.node;
					node.val = pair.succVal;
					return node;
				}
				return null; // leaf node;
			} else if (node.val < key) {
				node.right = deleteNode(node.right, key);
			} else {
				node.left = deleteNode(node.left, key);
			}

			return node;
		}

		private Pair inorderSuccessor(TreeNode node) {
			if (node.left != null) {
				var pair = inorderSuccessor(node.left);
				node.left = pair.node;
				return new Pair(node, pair.succVal);
			}

			if (node.right == null) {
				return new Pair(null, node.val); // leaf node;
			}

			// node has only right child
			// node.right != null, but node.left == null
			var pair = inorderSuccessor(node.right);
			var orgNodeVal = node.val;
			System.out.println("value of pair is: " + pair.node + ", " + pair.succVal);
			node.val = pair.succVal;
			node.right = pair.node;

			return new Pair(node, orgNodeVal);
		}
	}

}
