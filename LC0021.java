class LC0021 {
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
		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			ListNode newHead = new ListNode(-1);
			ListNode node = newHead;

			while (list1 != null && list2 != null) {
				if (list1.val < list2.val) {
					var nextNode = list1.next;
					list1.next = null;
					node.next = list1;
					list1 = nextNode;
				} else {
					var nextNode = list2.next;
					list2.next = null;
					node.next = list2;
					list2 = nextNode;
				}
				node = node.next;
			}

			if (list1 != null) {
				node.next = list1;
			}

			if (list2 != null) {
				node.next = list2;
			}

			return newHead.next;
		}
	}
}
