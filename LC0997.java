import java.util.*;

public class LC0997 {
	class Solution {
		public int findJudge(int n, int[][] trust) {
			Map<Integer, Integer> trustMap = new HashMap<>();
			Map<Integer, Integer> trustsMap = new HashMap<>();
			// [ai, bi] ai -> bi (ai trusts bi)

			for (var trustTuple : trust) {
				var ai = trustTuple[0];
				var bi = trustTuple[1];
				trustMap.put(bi, trustMap.getOrDefault(bi, 0) + 1);
				trustsMap.put(ai, trustsMap.getOrDefault(ai, 0) + 1);
			}

			for (var entry : trustMap.entrySet()) {
				if (entry.getValue() + 1 == n && (trustsMap.getOrDefault(entry.getKey(), 0) == 0)) {
					return entry.getKey();
				}
			}

			return -1;
		}
	}
}
