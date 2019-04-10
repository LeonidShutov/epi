package strings;

public class T76 {
	private static String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder res = new StringBuilder();
		for (String word : words) {
			res.insert(0, " ").insert(0, word);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String s = "Alice likes Bob and me not";
		System.out.println(reverseWords(s));
		s = "Alice";
		System.out.println(reverseWords(s));
		s = "";
		System.out.println(reverseWords(s));
	}
}
