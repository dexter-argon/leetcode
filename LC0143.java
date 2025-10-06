import java.util.*;

class LC0143 {

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

		private ListNode reverseList(ListNode head) {
			ListNode node = head, prev = null;

			while (node != null) {
				var nextNode = node.next;
				node.next = prev;
				prev = node;
				node = nextNode;
			}

			return prev;
		}

		private void merge(ListNode list1, ListNode list2) {

			while (list1 != null && list2 != null) {
				var nextNode = list2.next;
				list2.next = list1.next;
				list1.next = list2;
				list1 = list2.next;
				list2 = nextNode;
			}
		}

		public void reorderList(ListNode head) {
			ListNode fast = head, slow = head;

			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}

			var newHead = reverseList(slow.next);
			slow.next = null;

			merge(head, newHead);
		}

	}
}
