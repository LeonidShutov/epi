package strings;

import java.util.Arrays;

public class T74 {
	public static void modifyArray(int k, char[] c) {
		//remove b
		for (int i = 0; i < k; i++) {
			if (c[i] == 'b') {
				if (k + 1 - i >= 0) {
					System.arraycopy(c, i + 1, c, i, k - i);
				}
			}
		}
		//replace a by d, d
		for (int i = 0; i < k; i++) {
			if (c[i] == 'a') {
				c[i] = 'd';
				if (k + 1 - i + 1 >= 0) {
					System.arraycopy(c, i + 1, c, i + 2, k - i - 1);
				}
				c[i + 1] = 'd';
			}
		}
	}

	public static void main(String[] args) {
		char[] c = {'a', 'b', 'a', 'c', 'c', 'b', 'x'};
		modifyArray(6, c);
		System.out.println(Arrays.toString(c));
	}
}
