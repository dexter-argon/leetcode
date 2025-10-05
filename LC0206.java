class LC0206 {
	/**
	 * Definition for singly-linked list.
	 */
	static public class ListNode {
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
		public ListNode reverseList(ListNode head) {
			ListNode prev = null;
			ListNode node = head, nextNode = null;

			while (node != null) {
				nextNode = node.next;
				node.next = prev;
				prev = node;
				node = nextNode;
			}
			return prev;
		}
	}
}
