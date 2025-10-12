class LC1011 {
	class Solution {

		private boolean isShippable(int[] weights, int days, int capacity) {
			int numOfDaysRequired = 0;
			int weightAddedSoFar = 0;
			for (var weight : weights) {
				if (weight > capacity) {
					return false;
				}
				if (weightAddedSoFar + weight > capacity) {
					weightAddedSoFar = weight;
					++numOfDaysRequired;
					continue;
				}
				weightAddedSoFar += weight;
			}
			if (weightAddedSoFar > 0) {
				++numOfDaysRequired;
			}

			return numOfDaysRequired <= days;
		}

		public int shipWithinDays(int[] weights, int days) {
			int sumOfWeights = 0;
			int maxWeight = 0;

			for (var weight : weights) {
				sumOfWeights += weight;
				maxWeight = Math.max(maxWeight, weight);
			}

			int low = maxWeight, high = sumOfWeights;
			int result = 0;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (isShippable(weights, days, mid)) {
					result = mid;
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			return result;
		}
	}
}
