package strings;

public class T71 {
	public static int stoi(String s) {
		int res = 0;
		boolean neg = false;
		if (s.charAt(0) == '-') {
			neg = true;
			s = s.substring(1);
		}
		for (int i = 0; i < s.length(); i++) {
			res = res * 10 + (s.charAt(i) - '0');
		}
		return neg ? -res : res;
	}

	public static String itos(int i) {
		boolean neg = false;
		if (i==0){
			return "0";
		}
		if (i < 0) {
			neg = true;
		}
		StringBuilder s = new StringBuilder();
		while (i != 0) {
			s.append((char) ('0' + Math.abs(i % 10)));
			i = i / 10;
		}
		if (neg) {
			s.append("-");
		}
		return s.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(stoi("-123"));
		System.out.println(stoi("123"));
		System.out.println(stoi("0"));
		System.out.println(itos(-134567));
		System.out.println(itos(34567));
		System.out.println(itos(0));
	}
}
