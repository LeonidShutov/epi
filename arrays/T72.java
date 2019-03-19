package arrays;

public class T72 {
	public static Integer sto10(String s, int base) {
		Integer res = 0;
		boolean neg = false;
		if (s.charAt(0) == '-') {
			neg = true;
			s = s.substring(1);
		}
		for (int i = 0; i < s.length(); i++) {
			res = res * base + getDigit(s.charAt(i));
		}
		return neg ? -res : res;
	}

	public static String itos(int i, int base) {
		boolean neg = false;
		if (i == 0) {
			return "0";
		}
		if (i < 0) {
			neg = true;
		}
		StringBuilder s = new StringBuilder();
		while (i != 0) {
			s.append(getChar(i, base));
			i = i / base;
		}
		if (neg) {
			s.append("-");
		}
		return s.reverse().toString();
	}

	private static char getChar(int i, int base) {
		int c = Math.abs(i % base);
		if (c < 10) {
			return (char) ('0' + c);
		}
		switch (c) {
			case 10:
				return 'A';
			case 11:
				return 'B';
			case 12:
				return 'C';
			case 13:
				return 'D';
			case 14:
				return 'E';
			case 15:
				return 'F';
			default:
				return ' ';
		}
	}

	private static int getDigit(Character c) {
		switch (c) {
			case 'A':
				return 10;
			case 'B':
				return 11;
			case 'C':
				return 12;
			case 'D':
				return 13;
			case 'E':
				return 14;
			case 'F':
				return 15;
			default:
				return c - '0';
		}
	}

	public static String baseConverter(String s, int b1, int b2) {
		if (b1 == b2) {
			return s;
		}
		int base10 = sto10(s, b1);
		return itos(base10, b2);
	}

	public static void main(String[] args) {
		System.out.println(baseConverter("-615", 7, 13));
		System.out.println(baseConverter("1A7", 13, 7));
		System.out.println(baseConverter("123", 9, 9));
		System.out.println(baseConverter("0", 4, 16));
		System.out.println(baseConverter("129", 10, 2));
	}
}
