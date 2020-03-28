import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppearancesTest {

	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
		}
		return list;
	}

	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abcde");
		List<String> b = stringToList("fghij");
		assertEquals(5, Appearances.sameCount(a, a));
		assertEquals(0, Appearances.sameCount(a, b));

		a = stringToList("01234");
		b = stringToList("56789");
		assertEquals(5, Appearances.sameCount(a, a));
		assertEquals(0, Appearances.sameCount(a, b));
	}

	@Test
	public void testSameCount2() {
		List<String> a = stringToList("aabbcc");
		List<String> b = stringToList("bbccdd");
		List<String> c = stringToList("abcdef");
		assertEquals(3, Appearances.sameCount(a, a));
		assertEquals(2, Appearances.sameCount(a, b));
		assertEquals(0, Appearances.sameCount(a, c));
	}

	@Test
	public void testSameCount3() {
		List<Integer> a = Arrays.asList(0, 1, 2, 3, 4);
		List<Integer> b = Arrays.asList(4, 3, 2, 1, 0);
		List<Integer> c = Arrays.asList(5, 6, 7, 8, 9);
		assertEquals(5, Appearances.sameCount(a, a));
		assertEquals(5, Appearances.sameCount(a, b));
		assertEquals(0, Appearances.sameCount(a, c));
	}

	@Test
	public void testSameCount4() {
		List<Integer> a = Arrays.asList(10, 11, 11, 12, 12, 12);
		List<Integer> b = Arrays.asList(10, 10, 11, 11, 12, 12);
		List<Integer> c = Arrays.asList(10, 11, 12, 13, 14, 15);
		assertEquals(3, Appearances.sameCount(a, a));
		assertEquals(1, Appearances.sameCount(a, b));
		assertEquals(1, Appearances.sameCount(a, c));
	}

	@Test
	public void testSameCount5() {
		List<String> a = stringToList("");
		List<String> b = stringToList(" ");
		List<String> c = stringToList("c");
		assertEquals(0, Appearances.sameCount(a, a));
		assertEquals(0, Appearances.sameCount(a, b));
		assertEquals(0, Appearances.sameCount(a, c));

		List<Integer> d = Arrays.asList();
		List<Integer> e = Arrays.asList(1);
		assertEquals(0, Appearances.sameCount(d, d));
		assertEquals(0, Appearances.sameCount(d, e));
	}

}
