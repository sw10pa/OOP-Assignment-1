import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharGridTest {

	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'}};
		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea('b'));
		assertEquals(1, cg.charArea('z'));
		assertEquals(1, cg.charArea(' '));
		assertEquals(4, cg.charArea('a'));
	}

	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}};
		CharGrid cg = new CharGrid(grid);

		assertEquals(1, cg.charArea('c'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(6, cg.charArea('a'));
		assertEquals(9, cg.charArea(' '));
	}

	@Test
	public void testCharArea3() {
		char[][] grid = new char[][] {};
		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea(' '));
		assertEquals(0, cg.charArea('a'));
	}

	@Test
	public void testCountPlus1() {
		char[][] grid = new char[][] {
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
				{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
				{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
				{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
				{' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}};
		CharGrid cg = new CharGrid(grid);
		assertEquals(2, cg.countPlus());
	}

	@Test
	public void testCountPlus2() {
		char[][] grid = new char[][] {
				{' ', 'O', ' ', 'I', ' ', 'O', ' '},
				{'O', 'O', 'O', 'I', 'O', 'O', 'O'},
				{' ', 'O', ' ', 'I', ' ', 'O', ' '},
				{'I', 'I', 'I', 'I', 'I', 'I', 'I'},
				{' ', 'O', ' ', 'I', ' ', 'O', ' '},
				{'O', 'O', 'O', 'I', 'O', 'O', 'O'},
				{' ', 'O', ' ', 'I', ' ', 'O', ' '}};
		CharGrid cg = new CharGrid(grid);
		assertEquals(5, cg.countPlus());
	}

	@Test
	public void testCountPlus3() {
		char[][] grid = new char[][] {
				{'X', 'X', ' ', 'X', 'X'},
				{'X', 'X', ' ', 'X', 'X'},
				{' ', ' ', ' ', ' ', ' '},
				{'X', 'X', ' ', 'X', 'X'},
				{'X', 'X', ' ', 'X', 'X'}};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}

	@Test
	public void testCountPlus4() {
		char[][] grid = new char[][] {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}

	@Test
	public void testCountPlus5() {
		char[][] grid = new char[][] {{' '}};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}

	@Test
	public void testCountPlus6() {
		char[][] grid = new char[][] {};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}
	
}
