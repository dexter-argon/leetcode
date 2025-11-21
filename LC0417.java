import java.util.*;

public class LC0417 {
	class Solution {
		public final int REACHABLE = -1;
		public final int VISITED = -4;

		public List<List<Integer>> pacificAtlantic(int[][] heights) {
			int m = heights.length;
			if (m == 0) {
				return List.of();
			}
			int n = heights[0].length;
			int[][] pacific = new int[m][n];
			int[][] atlantic = new int[m][n];

			List<List<Integer>> result = new ArrayList<>();

			for (var i = 0; i < m; ++i) {
				dfs(heights, pacific, i, 0);
				dfs(heights, atlantic, i, n - 1);
			}

			for (var i = 0; i < n; ++i) {
				dfs(heights, pacific, 0, i);
				dfs(heights, atlantic, m - 1, i);
			}

			for (var i = 0; i < m; ++i) {
				for (var j = 0; j < n; ++j) {
					if (pacific[i][j] == REACHABLE && atlantic[i][j] == REACHABLE) {
						result.add(List.of(i, j));
					}
				}
			}

			return result;
		}

		int[] dir = new int[] { 0, 1, 0, -1 };

		private void dfs(int[][] heights, int[][] dp, int row, int col) {
			// edge
			if (dp[row][col] == REACHABLE) {
				return;
			}
			// Guard condition for visited cells
			if (heights[row][col] == VISITED) {
				return;
			}

			int m = heights.length;
			int n = heights[0].length;

			var ogHeight = heights[row][col];
			heights[row][col] = VISITED;
			dp[row][col] = REACHABLE;

			for (var i = 0; i < dir.length; ++i) {
				int newRow = row + dir[i];
				int newCol = col + dir[(i + 1) % dir.length];

				if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n || ogHeight > heights[newRow][newCol]) {
					continue;
				}
				dfs(heights, dp, newRow, newCol);
			}

			heights[row][col] = ogHeight;
			return;
		}
	}
}
