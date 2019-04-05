package strings;

public class T75 {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal, Panama.";
		System.out.println(isPalindromic(s));
		String s1 = "asdgSDFDgsdfg";
		System.out.println(isPalindromic(s1));
	}

	private static boolean isPalindromic(String s) {
		s = s.toLowerCase();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while (!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
				i++;
			}
			while (!(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')) {
				j--;
			}
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
