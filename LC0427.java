class LC0427 {

	static class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}
	}

	static class Solution {
		/**
		 *
		 * @return: QuadTree root node
		 * @args: two dimension Grid
		 *
		 *        set val to true/false if all values of grid is 1/0, and mark it as
		 *        Leaf.
		 *        else, divide the grid in four parts and continue;
		 *
		 *
		 */
		public Node construct(int[][] grid) {
			int gridLen = grid.length;

			return constructQuadTree(grid, 0, 0, gridLen);
		}

		private Node constructQuadTree(int[][] grid, int startRow, int startCol, int len) {
			Node node = new Node(true, false);
			int gridState = isGridSame(grid, startRow, startCol, len);
			if (gridState != -1) {
				node.val = (gridState == 1);
				node.isLeaf = true;
				return node;
			}

			int newLen = len / 2;
			node.topLeft = constructQuadTree(grid, startRow, startCol, newLen);
			node.topRight = constructQuadTree(grid, startRow, startCol + newLen, newLen);
			node.bottomLeft = constructQuadTree(grid, startRow + newLen, startCol, newLen);
			node.bottomRight = constructQuadTree(grid, startRow + newLen, startCol + newLen, newLen);

			return node;
		}

		private int isGridSame(int[][] grid, int startRow, int startCol, int len) {
			int initVal = grid[startRow][startCol];

			for (int i = startRow; i < startRow + len; i++) {
				for (int j = startCol; j < startCol + len; j++) {
					if (grid[i][j] != initVal) {
						return -1;
					}
				}
			}

			return initVal;
		}
	}
}
