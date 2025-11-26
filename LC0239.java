import java.util.*;

public class LC0239 {
	public class Solution {

		public int[] maxSlidingWindow(int[] nums, int k) {

			int n = nums.length;
			int[] slidingWindow = new int[n - k + 1];
			ArrayDeque<Integer> q = new ArrayDeque<>();

			for (int i = 0, j = 0; i < n; i += 1) {
				var currItem = nums[i];
				while (!q.isEmpty()) {
					var item = q.peekLast();
					if (currItem < nums[item]) {
						break;
					} else {
						q.pollLast();
					}
				}
				q.add(i);

				if (i < k - 1) {
					continue;
				}

				while (!q.isEmpty() && q.peekFirst() < (i - k + 1)) {
					q.pollFirst();
				}

				slidingWindow[j++] = nums[q.peekFirst()];
			}

			return slidingWindow;
		}
	}
}
