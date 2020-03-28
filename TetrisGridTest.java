import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TetrisGridTest {

	@Test
	public void testClearRows1() {
		boolean[][] before = {
			{true, true, false},
			{false, true, true}};

		boolean[][] after = {
			{true, false, false},
			{false, true, false}};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}

	@Test
	public void testClearRows2() {
		boolean[][] before = {
				{true, true, true},
				{true, true, true}};

		boolean[][] after = {
				{false, false, false},
				{false, false, false}};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}

	@Test
	public void testClearRows3() {
		boolean[][] before = {
				{false, false, false},
				{false, false, false},
				{false, false, false}};

		boolean[][] after = {
				{false, false, false},
				{false, false, false},
				{false, false, false}};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}

	@Test
	public void testClearRows4() {
		boolean[][] before = {
				{true, true, false, false}};

		boolean[][] after = {
				{false, false, false, false}};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}

	@Test
	public void testClearRows5() {
		boolean[][] before = {{true}};

		boolean[][] after = {{false}};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}
	
}
