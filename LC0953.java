import java.util.*;

public class LC0953 {
	class Solution {
		public boolean isAlienSorted(String[] words, String order) {
			Map<Character, Integer> alphabetMap = new HashMap<>();

			for (int i = 0; i < order.length(); i++) {
				alphabetMap.put(order.charAt(i), i);
			}

			for (int i = 0; i < words.length; ++i) {
				for (int j = i + 1; j < words.length; ++j) {
					if (compareAlienWords(words[i], words[j], alphabetMap) > 0) {
						return false;
					}
				}
			}
			return true;
		}

		private int compareAlienWords(String firstStr, String secondStr, Map<Character, Integer> alphabetMap) {
			int m = firstStr.length(), n = secondStr.length();
			for (var i = 0; i < Math.min(m, n); ++i) {
				char c1 = firstStr.charAt(i), c2 = secondStr.charAt(i);
				if (firstStr.charAt(i) == secondStr.charAt(i)) {
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
