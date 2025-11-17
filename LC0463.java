public class LC0463 {
	class Solution {
		private final int WATER = 0;
		private final int LAND = 1;
		private final int VISITED = 2;
		private int[] directions = new int[] { 0, 1, 0, -1 };

		public int islandPerimeter(int[][] grid) {
			int perimeter = 0;

			for (int row = 0; row < grid.length; ++row) {
				for (int col = 0; col < grid[0].length; ++col) {
					if (grid[row][col] == LAND) {
						perimeter += 4;
						for (var dir = 0; dir < directions.length; dir++) {
							int newRow = row + directions[dir];
							int newCol = col + directions[(dir + 1) % directions.length];

							if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
									|| grid[newRow][newCol] == WATER) {
								continue;
							}

							perimeter -= 1;
						}
					}
				}
			}

			return perimeter;
		}

		// Alternate approach
		private int dfs(int[][] grid, int row, int col) {
			int result = 4;
			grid[row][col] = VISITED;

			for (var dir = 0; dir < directions.length; dir++) {
				int X = row + directions[dir];
				int Y = col + directions[(dir + 1) % directions.length];

				if (X < 0 || X >= grid.length || Y < 0 || Y >= grid[0].length || grid[X][Y] == WATER) {
					continue;
				}

				if (grid[X][Y] == VISITED) {
					result -= 1;
					continue;
				}

				result += dfs(grid, X, Y) - 1;
			}

			return result;
		}
	}
}
