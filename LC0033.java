class LC0033 {
	class Solution {
		public int search(int[] arr, int target) {
			int low = 0, high = arr.length - 1;

			while (low <= high) {
				var mid = low + (high - low) / 2;

				if (arr[mid] == target) {
					return mid;
				} else if (arr[mid] <= arr[high]) {
					// later half is sorted.
					if ((target >= arr[mid]) && (target <= arr[high])) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				} else {
					if ((target <= arr[mid]) && (target >= arr[low])) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}

				}
			}

			return -1;
		}
	}
}
