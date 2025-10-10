import java.util.*;

class LC0146 {
	class LRUCache {

		// Build Doubly LinkedList
		static class DLL {
			Node head;
			Node tail;

			DLL(Node head, Node tail) {
				this.head = head;
				this.tail = tail;
			}

			DLL() {
				this.head = new Node(-1, -1);
				this.tail = new Node(-2, -2);
				this.head.next = this.tail;
				this.tail.prev = this.head;
			}

			void insertAtHead(Node node) {
				node.next = this.head.next;
				this.head.next = node;
				node.prev = this.head;
				node.next.prev = node;
			}

			void delete(Node node) {
				Node prevNode = node.prev;
				Node nextNode = node.next;
				nextNode.prev = prevNode;
				prevNode.next = nextNode;
			}

			int removeTailNode() {
				Node nodeToDel = tail.prev;
				int key = nodeToDel.key;
				delete(nodeToDel);
				return key;
			}

		}

		static class Node {
			int key;
			int val;
			Node prev;
			Node next;

			Node(int key, int val) {
				this.key = key;
				this.val = val;
				this.prev = null;
				this.next = null;
			}
		}

		Map<Integer, Node> nodesMap = new HashMap<>();
		int lruCapacity = 0;
		DLL dll;

		public LRUCache(int capacity) {
			this.lruCapacity = capacity;
			this.dll = new DLL();
		}

		private boolean isFull() {
			return this.nodesMap.size() == this.lruCapacity;
		}

		public int get(int key) {
			if (!nodesMap.containsKey(key)) {
				return -1;
			}
			// make it more recent
			var node = nodesMap.get(key);
			dll.delete(node);
			dll.insertAtHead(node);
			return node.val;
		}

		public void put(int key, int value) {
			Node node = new Node(key, value);
			if (nodesMap.containsKey(key)) {
				// node is present, we don't have to delete any nodes from the list/map
				// make the node most recent
				node = nodesMap.get(key);
				node.val = value;
				dll.delete(node);
				dll.insertAtHead(node);
				return;
			}

			// cache could be full or not, but node is not present in the map/DLL

			// if not full
			if (!isFull()) {
				dll.insertAtHead(node);
				nodesMap.put(key, node);
				return;
			}

			// cache is full, and key is not present
			int removedNodesKey = dll.removeTailNode();
			nodesMap.remove(removedNodesKey);
			dll.insertAtHead(node);
			nodesMap.put(key, node);
			return;
		}
	}

}
