import java.util.*;

class LC0460 {

	class LFUCache {
		static class Node {
			int key;
			int value;
			int freq;

			Node(int key, int value, int freq) {
				this.key = key;
				this.value = value;
				this.freq = freq;
			}
		}

		private PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.freq - n2.freq);
		private Map<Integer, Node> nodesMap = new HashMap<>();

		public LFUCache(int capacity) {

		}

		public int get(int key) {

		}

		public void put(int key, int value) {

		}
	}

}
