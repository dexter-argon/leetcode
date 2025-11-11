import java.util.*;

public class LC0133 {

	/*
	 * // Definition for a Node.
	 */
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	class Solution {
		public Node cloneGraph(Node node) {
			Map<Node, Node> nodesMap = new HashMap<>();

			dfs(node, nodesMap, new HashSet<>());

			addConnections(node, nodesMap, new HashSet<>());

			return nodesMap.getOrDefault(node, null);
		}

		private void dfs(Node node, Map<Node, Node> nodesMap, Set<Node> visitedNodes) {
			if (node == null || visitedNodes.contains(node)) {
				return; // node is visited
			}

			var newNode = new Node(node.val);
			nodesMap.put(node, newNode);
			visitedNodes.add(node);
			var neighbors = node.neighbors;
			for (var neighbor : neighbors) {
				dfs(neighbor, nodesMap, visitedNodes);
			}

		}

		private void addConnections(Node node, Map<Node, Node> nodesMap, Set<Node> visitedNodes) {
			if (node == null || visitedNodes.contains(node)) {
				return; // node is visited
			}

			var newNode = nodesMap.get(node);
			visitedNodes.add(node);
			var neighbors = node.neighbors;
			for (var neighbor : neighbors) {
				var newNeighbor = nodesMap.get(neighbor);
				newNode.neighbors.add(newNeighbor);
				addConnections(neighbor, nodesMap, visitedNodes);
			}

		}
	}
}
