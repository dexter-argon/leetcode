class LC0035 {
	class Solution {
		public int searchInsert(int[] nums, int target) {
			int low = 0, high = nums.length - 1;

			while (low <= high) {
				var mid = low + (high - low) / 2;
				var midValue = nums[mid];

				if (midValue == target) {
					return mid;
				} else if (midValue > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			return low;
		}
	}
}
