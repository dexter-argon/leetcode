import java.util.*;


class LC0994 {

	static class Solution {
		private static final int EMPTY = 0;
		private static final int FRESH = 1;
		private static final int ROTTEN = 2;
		/**
		 * @param grid of cell containing rotton, fresh oranges and empty cell.
		 * @return time to rot all fresh oranges, if not possible return -1
		*/	
		// BFS seems appropriate, but where do we start, as there could be multiple rotton oranges.
		public int orangesRotting(int[][] grid) {
			int timeElapsed = 0;
			int freshOrangesCount = 0;
			int[] directions = new int[]{0, 1, 0, -1};
			Queue<int[]> q = new LinkedList<>();
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length; col += 1) {
					if (grid[row][col] == ROTTEN) {
						q.add(new int[]{row, col});
					} else if (grid[row][col] == FRESH) {
						freshOrangesCount += 1;
					}
				}
			}

			while(!q.isEmpty()) {
				boolean rottenInThisMinute = false;
				int qSize = q.size();
				for (int p = 0; p < qSize; p += 1) {
					int[] cell = q.poll();
					int x = cell[0];
					int y = cell[1];
					for (int dir = 0; dir < directions.length; dir += 1) {
						int xDir = x + directions[dir];
						int yDir = y + directions[(dir+1)%directions.length];
						if (xDir < 0 || xDir >= grid.length || yDir < 0 || yDir >= grid[0].length) {
							continue;
						}
						if (grid[xDir][yDir] == FRESH) {
							freshOrangesCount -= 1;
							q.add(new int[]{xDir, yDir});
							grid[xDir][yDir] = 2;
							rottenInThisMinute = true;
						}
					}
				}
				if (rottenInThisMinute) {
					timeElapsed += 1;
				}
			}

			return (0 == freshOrangesCount) ? timeElapsed : -1;
		}

	}

	public static void main(String[] args) {
		// int [][]grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
		// int [][]grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
		// int [][]grid = new int[][]{{0, 2}};
		int [][]grid = new int[][]{{0}};

		Solution sol = new Solution();
		System.out.println(sol.orangesRotting(grid));
	}
}