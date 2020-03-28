public class TetrisGrid {

	private boolean[][] grid;

	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}

	public void clearRows() {
		for (int col = 0; col < grid[0].length; col++) {
			if (isFilled(col)) {
				shiftLeft(col);
				col--;
			}
		}
	}

	private boolean isFilled(int col) {
		for (int row = 0; row < grid.length; row++) {
			if (!grid[row][col]) return false;
		}
		return true;
	}

	private void shiftLeft(int col) {
		while(col != grid[0].length - 1) {
			for (int row = 0; row < grid.length; row++) {
				grid[row][col] = grid[row][col + 1];
			}
			col++;
		}
		for (int row = 0; row < grid.length; row++) {
			grid[row][col] = false;
		}
	}

	boolean[][] getGrid() {
		return this.grid;
	}

}
