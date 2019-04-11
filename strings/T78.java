package strings;

public class T78 {
	private static String lookAndSay(int n) {
		StringBuilder s = new StringBuilder("1");
		if (n == 0) {
			return "";
		}
		while (n > 1) {
			String cur = s.toString();
			s = new StringBuilder();
			int prev = cur.charAt(0) - '0';
			int cnt = 1;
			int curI = prev;
			for (int i = 1; i < cur.length(); i++) {
				curI = cur.charAt(i) - '0';
				if (prev == curI) {
					cnt++;
					continue;
				}
				s.append(String.valueOf(cnt)).append(String.valueOf(prev));
				prev = curI;
				cnt = 1;
			}
			s.append(String.valueOf(cnt)).append(String.valueOf(curI));
			n--;
		}
		return s.toString();
	}

	public static void main(String[] args) {
		int n = 8;
		System.out.println(lookAndSay(n));
	}
}
