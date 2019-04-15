package other;

import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int cur = 0;
		if (n > 0) {
			cur = scanner.nextInt();
			System.out.println(cur);
		}
		int c = 0;
		for (int i = 1; i < n; i++) {
			c = scanner.nextInt();
			if (c == cur) {
				continue;
			} else {
				cur = c;
				System.out.println(cur);
			}
		}
	}
}
