public class CharGrid {

	private char[][] grid;

	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	public int charArea(char ch) {
		int minRow = grid.length;
		int minCol = grid.length > 0 ? grid[0].length : 0;
		int maxRow = -1;
		int maxCol = -1;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == ch) {
					minRow = Math.min(minRow, row);
					minCol = Math.min(minCol, col);
					maxRow = Math.max(maxRow, row);
					maxCol = Math.max(maxCol, col);
				}
			}
		}

		if (maxRow == -1) return 0;
		return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	}

	public int countPlus() {
		int pluses = 0;
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[i].length - 1; j++) {
				if (isPlus(i, j)) pluses++;
			}
		}
		return pluses;
	}

	private boolean isPlus(int i, int j) {
		int leftArm = measureArm(i, j, 0, -1);
		int upperArm = measureArm(i, j, -1, 0);
		int rightArm = measureArm(i, j, 0, 1);
		int lowerArm = measureArm(i, j, 1, 0);
		return leftArm > 1 &&
			   leftArm == upperArm && upperArm == rightArm && rightArm == lowerArm;
	}

	private int measureArm(int i, int j, int di, int dj) {
		int length = 0;
		char ch = grid[i][j];
		while (inBounds(i, j)) {
			if (grid[i][j] != ch) break;
			length++;
			i += di;
			j += dj;
		}
		return length;
	}

	private boolean inBounds(int i, int j) {
		return i >= 0 && i < grid.length &&
			   j >= 0 && j < grid[i].length;
	}
	
}
