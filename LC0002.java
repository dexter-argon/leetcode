class LC0002 {

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
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			var carry = 0;
			ListNode head = new ListNode(-1), node = head;
			while (l1 != null || l2 != null) {
				var v1 = (l1 != null) ? l1.val : 0; // value from list1
				var v2 = (l2 != null) ? l2.val : 0; // value from list2
				var num = v1 + v2 + carry;
				carry = num / 10;
				num = num % 10;

				node.next = new ListNode(num);
				node = node.next;

				l1 = (l1 != null) ? l1.next : null;
				l2 = (l2 != null) ? l2.next : null;
			}

			if (carry == 1) {
				node.next = new ListNode(carry);
			}

			return head.next;
		}
	}
}
