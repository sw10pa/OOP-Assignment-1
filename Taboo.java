import java.util.*;

public class Taboo<T> {

	HashMap<T, HashSet<T>> rules;

	public Taboo(List<T> rules) {
		this.rules = new HashMap<>();
		for (int i = 0; i < rules.size() - 1; i++) {
			T curr = rules.get(i);
			T next = rules.get(i + 1);
			if (curr == null || next == null) continue;

			HashSet<T> value  = this.rules.get(curr);
			if (value == null) value = new HashSet<>();
			value.add(next);

			this.rules.put(curr, value);
		}
	}

	public Set<T> noFollow(T elem) {
		HashSet<T> value  = this.rules.get(elem);
		if (value == null) value = new HashSet<>();
		return value;
	}

	public void reduce(List<T> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			T curr = list.get(i);
			if (this.rules.containsKey(curr)) {
				HashSet<T> value  = this.rules.get(curr);
				T next = list.get(i + 1);
				if (value.contains(next)) {
					list.remove(i + 1);
					i--;
				}
			}
		}
	}

}
