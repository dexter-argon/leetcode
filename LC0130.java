public class LC0130 {
	class Solution {
		private final char VISITED = '*';
		private final char REGION = 'O';
		private final char SURROUND = 'X';

		public void solve(char[][] board) {
			int m = board.length, n = board[0].length;

			for (var i = 0; i < m; i++) {
				if (board[i][0] == REGION) {
					dfs(board, i, 0);
				}
				if (board[i][n - 1] == REGION) {
					dfs(board, i, n - 1);
				}

			}

			for (var i = 0; i < n; i++) {
				if (board[0][i] == REGION) {
					dfs(board, 0, i);
				}
				if (board[m - 1][i] == REGION) {
					dfs(board, m - 1, i);
				}
			}

			for (var i = 0; i < m; ++i) {
				for (var j = 0; j < n; ++j) {
					if (board[i][j] == REGION) {
						board[i][j] = SURROUND;
					} else if (board[i][j] == VISITED) {
						board[i][j] = REGION;
					}
				}
			}
		}

		private void dfs(char[][] board, int row, int col) {
			int m = board.length, n = board[0].length;

			if (row < 0 || col < 0 || row >= m || col >= n) {
				return;
			}
			if (board[row][col] == VISITED || board[row][col] == SURROUND) {
				return;
			}

			board[row][col] = VISITED;

			dfs(board, row, col + 1);
			dfs(board, row + 1, col);
			dfs(board, row, col - 1);
			dfs(board, row - 1, col);
		}
	}
}
