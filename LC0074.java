class LC0074 {
	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			// first find the row where target might be present

			int low = 0, high = matrix.length - 1;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				int midValue = matrix[mid][0];

				if (midValue == target) {
					return true;
				} else if (midValue > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// we have found the row.
			int row = high;
			if (row < 0) {
				return false;
			}

			low = 0;
			high = matrix[0].length - 1;

			while (low <= high) {
				int mid = low + (high - low) / 2;
				int midValue = matrix[row][mid];

				if (midValue == target) {
					return true;
				} else if (midValue > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			return false;
		}
	}
}
