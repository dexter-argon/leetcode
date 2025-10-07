import java.util.*;

class LC0138 {
	// Definition for a Node.
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	class Solution {
		public Node copyRandomList(Node head) {
			Map<Node, Node> nodesMap = new HashMap<>();
			for (var node = head; node != null; node = node.next) {
				var newNode = new Node(node.val);
				nodesMap.put(node, newNode);
			}

			for (var node = head; node != null; node = node.next) {
				var newNode = nodesMap.get(node);
				if (node.next != null) {
					newNode.next = nodesMap.get(node.next);
				}
				if (node.random != null) {
					newNode.random = nodesMap.get(node.random);
				}
			}

			return nodesMap.getOrDefault(head, null);
		}
	}
}
