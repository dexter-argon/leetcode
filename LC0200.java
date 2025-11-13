import java.util.*;

public class LC0200 {
	class Solution {
		int[] dir = new int[] { 0, 1, 0, -1 };

		public int numIslands(char[][] grid) {
			var result = 0;

			for (var row = 0; row < grid.length; ++row) {
				for (var col = 0; col < grid[0].length; ++col) {
					if (grid[row][col] == '0') {
						continue;
					}
					grid[row][col] = '0';
					dfs(grid, row, col);
					++result;
				}
			}
			return result;
		}

		private void dfs(char[][] grid, int row, int col) {
			for (var i = 0; i < dir.length; ++i) {
				var xCor = row + dir[i];
				var yCor = col + dir[(i + 1) % dir.length];

				if (xCor < 0 || xCor >= grid.length || yCor < 0 || yCor >= grid[0].length || grid[xCor][yCor] == '0') {
					continue;
				}

				grid[xCor][yCor] = '0';
				dfs(grid, xCor, yCor);
			}

			return;
		}
	}
}
