import java.util.*;

public class LC0953 {
	class Solution {
		public boolean isAlienSorted(String[] words, String order) {
			Map<Character, Integer> alphabetMap = new HashMap<>();

			for (int i = 0; i < order.length(); i++) {
				alphabetMap.put(order.charAt(i), i);
			}

			for (int i = 0; i + 1 < words.length; ++i) {
				if (compareAlienWords(words[i], words[i + 1], alphabetMap) > 0) {
					return false;
				}
			}
			return true;
		}

		private int compareAlienWords(String firstStr, String secondStr, Map<Character, Integer> alphabetMap) {
			int m = firstStr.length(), n = secondStr.length();
			for (var i = 0; i < Math.min(m, n); ++i) {
				char c1 = firstStr.charAt(i), c2 = secondStr.charAt(i);
				if (c1 == c2) {
					continue;
				} else if (alphabetMap.get(c1) > alphabetMap.get(c2)) {
					return 1;
				} else {
					return -1;
				}
			}
			return m - n;
		}
	}
}
