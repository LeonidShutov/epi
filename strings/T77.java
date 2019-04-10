package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class T77 {
	private static Map<Character, Character[]> map = fillMap();

	private static Map<Character, Character[]> fillMap() {
		Map<Character, Character[]> characterMap = new HashMap<>();
		characterMap.put('2', new Character[]{'a', 'b', 'c'});
		characterMap.put('3', new Character[]{'d', 'e', 'f'});
		characterMap.put('4', new Character[]{'g', 'h', 'i'});
		characterMap.put('5', new Character[]{'j', 'k', 'l'});
		characterMap.put('6', new Character[]{'m', 'n', 'o'});
		characterMap.put('7', new Character[]{'p', 'q', 'r', 's'});
		characterMap.put('8', new Character[]{'t', 'u', 'v'});
		characterMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
		characterMap.put('0', new Character[]{});
		characterMap.put('1', new Character[]{});
		return characterMap;
	}

	private static List<String> calcWords(String s) {
		Character[] chars = IntStream.range(0, s.length()).mapToObj(s::charAt).toArray(Character[]::new);
		return calcFirstSymbol(chars, new ArrayList<>());

	}

	private static List<String> calcFirstSymbol(Character[] chars, List<String> perms) {
		List<String> rows = new ArrayList<>();
		for (int i = 0; i < map.get(chars[0]).length; i++) {
			rows.add(String.valueOf(map.get(chars[0])[i]));
		}

		List<String> strings = recCall(rows, 1, chars);
		for (String string : strings) {
			if (string.length() == chars.length) {
				perms.add(string);
			}
		}
		return perms;
	}

	private static List<String> recCall(List<String> rows, int k, Character[] chars) {
		List<String> res = new ArrayList<>();
		for (String row : rows) {
			for (int i = 0; i < map.get(chars[k]).length; i++) {
				res.add(row + String.valueOf(map.get(chars[k])[i]));
			}
		}
		if (k + 1 < chars.length) {
			res.addAll(recCall(res, k + 1, chars));
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "92384";
		List<String> res = calcWords(s);
		res.forEach(System.out::println);
	}
}