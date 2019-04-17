package other;

import java.util.Arrays;

public class MoveZeroes {
	private static void moveZeroes(int[] ar) {
		int z = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == 0) {
				z++;
			} else {
				ar[i - z] = ar[i];
			}
		}
		for (int i = ar.length - 1; i > ar.length - 1 - z; i--) {
			ar[i] = 0;
		}
	}

	public static void main(String[] args) {
		int[] ar = {1, 2, 0, 4, 0, 0, 5, 0, 3};
		moveZeroes(ar);
		System.out.println(Arrays.toString(ar));
		ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3};
		moveZeroes(ar);
		System.out.println(Arrays.toString(ar));
		ar = new int[]{1, 2, 3, 4, 8, 9, 5, 5, 3};
		moveZeroes(ar);
		System.out.println(Arrays.toString(ar));
		ar = new int[]{0, 0, 0};
		moveZeroes(ar);
		System.out.println(Arrays.toString(ar));
		ar = new int[]{1, 0, 0, 0, 0, 0, 0, 5, 3};
		moveZeroes(ar);
		System.out.println(Arrays.toString(ar));
	}
}
