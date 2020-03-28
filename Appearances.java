import java.util.*;

public class Appearances {

	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<T, Integer> map1 = countElems(a);
		HashMap<T, Integer> map2 = countElems(b);
		return sameValueElems(map1, map2);
	}

	private static <T> HashMap<T, Integer> countElems(Collection<T> elems) {
		HashMap<T, Integer> map = new HashMap<>();
		for (T elem : elems) {
			if (map.containsKey(elem)) {
				map.put(elem, map.get(elem) + 1);
			} else {
				map.put(elem, 1);
			}
		}
		return map;
	}

	private static <T> int sameValueElems(HashMap<T, Integer> map1, HashMap<T, Integer> map2) {
		int result = 0;
		for (T key : map1.keySet()) {
			if (map1.get(key) == map2.get(key)) {
				result++;
			}
		}
		return result;
	}

}
