class LC0092 {
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

		private ListNode reverse(ListNode begin, ListNode end) {
			ListNode prev = end.next;
			ListNode node = begin, lastNode = end.next;

			while (node != lastNode) {
				ListNode nextNode = node.next;
				node.next = prev;
				prev = node;
				node = nextNode;
			}

			return prev;
		}

		public ListNode reverseBetween(ListNode head, int left, int right) {
			ListNode newHead = new ListNode(-1);
			newHead.next = head;
			ListNode begin = newHead, end = newHead;

			while (left-- > 1) {
				begin = begin.next;
			}

			while (right-- > 0) {
				end = end.next;
			}

			begin.next = reverse(begin.next, end);

			return newHead.next;
		}

	}
}
