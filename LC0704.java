class LC0704 {
	class Solution {
		public int search(int[] nums, int target) {
			int low = 0, high = nums.length - 1;

			while (low <= high) {
				var mid = low + (high - low) / 2;
				var midVal = nums[mid];

				if (midVal == target) {
					return mid;
				} else if (midVal > target) {
					high = mid - 1;
				} else {
					// midVal is less than target
					low = mid + 1;
				}
			}

			return -1;
		}
	}
}
