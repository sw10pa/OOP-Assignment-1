import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCodeTest {

	@Test
	public void testMaxRun1() {
		assertEquals(1, StringCode.maxRun("a"));
		assertEquals(2, StringCode.maxRun("aa"));
		assertEquals(1, StringCode.maxRun("ab"));
	}

	@Test
	public void testMaxRun2() {
		assertEquals(3, StringCode.maxRun("aaa"));
		assertEquals(2, StringCode.maxRun("aab"));
		assertEquals(2, StringCode.maxRun("abb"));
		assertEquals(2, StringCode.maxRun("aabb"));
	}

	@Test
	public void testMaxRun3() {
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(1, StringCode.maxRun(" "));
		assertEquals(1, StringCode.maxRun("@"));
		assertEquals(2, StringCode.maxRun("@@"));
		assertEquals(1, StringCode.maxRun("@ @"));
	}

	@Test
	public void testBlowup1() {
		assertEquals("", StringCode.blowup("0"));
		assertEquals("", StringCode.blowup("1"));
		assertEquals("", StringCode.blowup("2"));
		assertEquals("a", StringCode.blowup("a"));
	}

	@Test
	public void testBlowup2() {
		assertEquals("aa", StringCode.blowup("aa"));
		assertEquals("ab", StringCode.blowup("ab"));

		assertEquals("", StringCode.blowup("00"));
		assertEquals("", StringCode.blowup("01"));
		assertEquals("", StringCode.blowup("02"));

		assertEquals("0", StringCode.blowup("10"));
		assertEquals("1", StringCode.blowup("11"));
		assertEquals("2", StringCode.blowup("12"));

		assertEquals("00", StringCode.blowup("20"));
		assertEquals("11", StringCode.blowup("21"));
		assertEquals("22", StringCode.blowup("22"));
	}

	@Test
	public void testBlowup3() {
		assertEquals("a", StringCode.blowup("a0"));
		assertEquals("b", StringCode.blowup("b1"));
		assertEquals("c", StringCode.blowup("c2"));

		assertEquals("a", StringCode.blowup("0a"));
		assertEquals("bb", StringCode.blowup("1b"));
		assertEquals("ccc", StringCode.blowup("2c"));
	}

	@Test
	public void testBlowup4() {
		assertEquals("", StringCode.blowup(""));
		assertEquals(" ", StringCode.blowup(" "));
		assertEquals("@", StringCode.blowup("@"));

		assertEquals("aaaaaaaaa", StringCode.blowup("aaaaaaaaa"));
		assertEquals("aaabbbccc", StringCode.blowup("aaabbbccc"));

		assertEquals("", StringCode.blowup("000000000"));
		assertEquals("11111111", StringCode.blowup("111111111"));
		assertEquals("2222222222222222", StringCode.blowup("222222222"));

		assertEquals("abbccc", StringCode.blowup("0a1b2c"));
		assertEquals("abcc", StringCode.blowup("a0b1c2"));
	}

	@Test
	public void testStringIntersect1() {
		assertTrue(StringCode.stringIntersect("a", "a", 1));
		assertFalse(StringCode.stringIntersect("a", "b", 1));

		assertTrue(StringCode.stringIntersect("ab", "ab", 2));
		assertFalse(StringCode.stringIntersect("ab", "ba", 2));
	}

	@Test
	public void testStringIntersect2() {
		assertTrue(StringCode.stringIntersect("ab", "ba", 1));
		assertTrue(StringCode.stringIntersect("ab", "bc", 1));
		assertFalse(StringCode.stringIntersect("ab", "cd", 1));

		assertTrue(StringCode.stringIntersect("aab", "baa", 2));
		assertFalse(StringCode.stringIntersect("aaa", "aba", 2));
	}

	@Test
	public void testStringIntersect3() {
		assertTrue(StringCode.stringIntersect(" ", " ", 1));
		assertTrue(StringCode.stringIntersect("@", "@", 1));

		assertFalse(StringCode.stringIntersect("", "", 1));
		assertFalse(StringCode.stringIntersect("#", "*", 1));
		assertFalse(StringCode.stringIntersect("a", "", 1));

		assertTrue(StringCode.stringIntersect("abba", "bbcc", 2));
		assertFalse(StringCode.stringIntersect("abcd", "defg", 2));
	}

}
