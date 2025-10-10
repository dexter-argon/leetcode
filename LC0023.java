import java.util.PriorityQueue;

class LC0023 {
	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			ListNode head = new ListNode(-1);
			var node = head;
			PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

			for (int i = 0; i < lists.length; i += 1) {
				if (lists[i] == null) {
					continue;
				}
				pq.add(lists[i]);
			}

			while (!pq.isEmpty()) {
				node.next = pq.poll();
				node = node.next;

				if (node.next != null) {
					pq.add(node.next);
				}
			}

			return head.next;
		}
	}
}
