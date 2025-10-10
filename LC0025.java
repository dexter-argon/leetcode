class LC0025 {

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

		private ListNode reverseList(ListNode start, ListNode end) {
			ListNode prev = end.next;
			ListNode lastNode = end.next;
			var node = start;

			while (node != lastNode) {
				var nextNode = node.next;
				node.next = prev;
				prev = node;
				node = nextNode;
			}

			return prev; // return the reversedHead
		}

		public ListNode reverseKGroup(ListNode head, int k) {
			ListNode newHead = new ListNode(-1);
			newHead.next = head;
			var node = newHead.next;
			var prev = newHead;

			while (node != null) {
				var start = node;
				var i = 0;
				for (; (node.next != null) && (i + 1 < k); i += 1) {
					node = node.next;
				}
				if (i + 1 == k) {
					// reverse the list
					prev.next = reverseList(start, node);
				} else {
					break;
				}
				prev = start;
				node = prev.next;
			}

			return newHead.next;
		}
	}
}
