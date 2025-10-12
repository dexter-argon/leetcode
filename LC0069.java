class LC0069 {
	class Solution {
		public int mySqrt(int x) {
			int low = 0, high = Integer.MAX_VALUE;

			while (low <= high) {
				int mid = low + (high - low) / 2;
				long square = ((long) mid) * mid;

				if (square == x) {
					return mid;
				} else if (square > x) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			return high;
		}
	}
}
