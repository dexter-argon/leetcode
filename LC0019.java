class LC0019 {
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
		public ListNode removeNthFromEnd(ListNode head, int n) {
			var fast = head;
			var slow = head;
			while (n-- > 0) {
				fast = fast.next;
			}

			while (fast != null && fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}

			if (slow == head && fast == null) {
				// node we are deleting is happens to be a head
				return slow.next;
			}
			// otherwise this would work for all of the nodes
			slow.next = slow.next.next;

			return head;
		}
	}
}
