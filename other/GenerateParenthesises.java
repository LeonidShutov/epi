package other;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateParenthesises {
	public static void main(String[] args) {
		int n = 3;
		Set<String> set = new HashSet<>();
		System.out.println(genParents(n, set,n).stream().sorted().collect(Collectors.toList()));
	}

	private static Set<String> genParents(int n, Set<String> res, int initial) {
		if (n==0){
			return res;
		}
		if (res.isEmpty()) {
			res.add("()");
			n--;
		}

		Set<String> cur = new HashSet<>();
		for (String r : res) {
			cur.add("()" + r);
			cur.add(r + "()");
			int i = 0;
			while (true) {
				StringBuilder s = new StringBuilder(r);
				if (r.indexOf("(", i) > -1) {
					StringBuilder toReplace = s.replace(r.indexOf("(", i), r.indexOf("(",i) + 1, "(()");
					cur.add(toReplace.toString());
					i++;
					if (i >= r.length()) {
						break;
					}
				} else {
					break;
				}
			}

		}
		res.addAll(genParents(n - 1, cur,initial));
		return res.stream().filter(s -> s.length()==initial*2).sorted().collect(Collectors.toSet());
	}
}
