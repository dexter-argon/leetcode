public class LC0076 {
	public class Solution {
		public String minWindow(String s, String t) {
			if (s.length() < t.length()) {
				return "";
			}

			// Map<Integer, Integer> freqCount = new HashMap<>();
			int[] freqCount = new int[128];

			for (var i = 0; i < t.length(); ++i) {
				int asciiCode = t.charAt(i);
				// freqCount.putIfAbsent(asciiCode, 0);
				freqCount[asciiCode] += 1;
				// freqCount.put(asciiCode, freqCount.get(asciiCode) + 1);
			}

			int startIdx = 0, endIdx = 0;
			int matchedCount = 0;
			int len = Integer.MAX_VALUE;
			int start = 0;

			while (endIdx < s.length()) {
				int code = s.charAt(endIdx);

				if (freqCount[code] > 0) {
					matchedCount++;
				}
				freqCount[code] -= 1;

				while (matchedCount == t.length()) {
					if (len > (endIdx - startIdx + 1)) {
						start = startIdx;
						len = endIdx - startIdx + 1;
					}
					int startCode = s.charAt(startIdx);
					freqCount[startCode] += 1;
					if (freqCount[startCode] > 0) {
						matchedCount -= 1;
					}
					++startIdx;
				}

				++endIdx;
			}

			return (len == Integer.MAX_VALUE) ? "" : s.substring(start, start + len);
		}
	}
}
