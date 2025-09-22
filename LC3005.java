import java.util.*;

class LC3005 {

	static class Solution {

		// find the count of #'s with max frequency
		public int maxFrequencyElements(int[] nums) {
			// base condition
			if (nums.length == 0) {
				return 0;
			}

			var freqCount = new HashMap<Integer, Integer>();
			var maxFrequency = 0;
			var result = 0;

			for (int num: nums) {
				freqCount.putIfAbsent(num, 0);
				var frequency = freqCount.get(num) + 1;
				freqCount.put(num, frequency);
				maxFrequency = Math.max(maxFrequency, frequency);
			}

			for (var entry: freqCount.entrySet()) {
				if (entry.getValue() != maxFrequency) {
					continue;
				}
				result += entry.getValue();
			}

			return result;
		}
	}



	public static void main(String[] args) {
		int[] nums = {1,2,2,3,1,4};
		// int[] nums = {1,2,3,4,5};

		Solution sol = new Solution();
		System.out.println(sol.maxFrequencyElements(nums));
	}




}