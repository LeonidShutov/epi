package strings;

import java.util.HashMap;
import java.util.Map;

public class T79 {
	static Map<String, Integer> map = new HashMap<>();

	private static int romanToInteger(String s) {
		initMap();
		int res = 0;
		Integer found;
		for (int i = 0; i < s.length() - 1; i++) {
			//check 2 symbols option
			String ch = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
			found = map.getOrDefault(ch, 0);
			if (found != 0) {
				res += found;
				i++;
			} else {
				//check 1 symbol option
				found = map.getOrDefault(String.valueOf(s.charAt(i)), 0);
				res += found;
			}
		}
		//check last elem in string
		found = map.getOrDefault(String.valueOf(s.charAt(s.length()-1)), 0);
		res += found;
		return res;
	}

	private static void initMap() {
		if (map.isEmpty()) {
			map.put(String.valueOf('I'), 1);
			map.put(String.valueOf('V'), 5);
			map.put(String.valueOf('X'), 10);
			map.put(String.valueOf('L'), 50);
			map.put(String.valueOf('C'), 100);
			map.put(String.valueOf('D'), 500);
			map.put(String.valueOf('M'), 1000);
			map.put("IV", 4);
			map.put("IX", 9);
			map.put("XL", 40);
			map.put("XC", 90);
			map.put("CD", 400);
			map.put("CM", 900);
		}
	}

	public static void main(String[] args) {
		String s = "MMDCXLVIII";
		System.out.println(romanToInteger(s));
	}
}
