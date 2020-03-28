import java.util.HashSet;

public class StringCode {

	public static int maxRun(String str) {
		if (str.isEmpty()) return 0;
		int maxRun = 1;
		int curRun = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				curRun++;
				maxRun = Math.max(maxRun, curRun);
			} else {
				curRun = 1;
			}
		}
		return maxRun;
	}

	public static String blowup(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (isDigit(i, str)) {
				result += nTimesNextChar(i, str);
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	private static boolean isDigit(int index, String str) {
		return str.charAt(index) >= '0' && str.charAt(index) <= '9';
	}

	private static String nTimesNextChar(int index, String str) {
		String result = "";
		if (index == str.length() - 1) return result;
		for (int i = '0'; i < str.charAt(index); i++) {
			result += str.charAt(index + 1);
		}
		return result;
	}

	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> substr1 = substrings(a, len);
		HashSet<String> substr2 = substrings(b, len);
		substr1.retainAll(substr2);
		return !substr1.isEmpty();
	}

	private static HashSet<String> substrings(String str, int len) {
		HashSet<String> result = new HashSet<>();
		for (int i = 0; i < str.length() - len + 1; i++) {
			result.add(str.substring(i, i + len));
		}
		return result;
	}

}
