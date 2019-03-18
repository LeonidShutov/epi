package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T617 {
	static List<Integer> getSpiralOrder(int[][] ar) {
		int n = ar.length;
		List<Integer> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
		if (n == 1) {
			res.add(ar[0][0]);
			return res;
		}
		for (int i = 0; i < n - 1; i++) {
			res.add(ar[0][i]);
		}
		for (int i = 0; i < n - 1; i++) {
			res.add(ar[i][n - 1]);
		}
		for (int i = 0; i < n - 1; i++) {
			res.add(ar[n - 1][n - 1 - i]);
		}
		for (int i = 0; i < n - 1; i++) {
			res.add(ar[n - 1 - i][0]);
		}
		res.addAll(getSpiralOrder(getSmallerArray(ar)));
		return res;
	}

	private static int[][] getSmallerArray(int[][] ar) {
		int[][] res = new int[ar.length - 2][ar.length - 2];
		for (int i = 0; i < res.length; i++) {
			res[i] = Arrays.copyOfRange(ar[i + 1], 1, ar.length - 1);
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] ar = new int[5][5];
		ar[0] = new int[]{1, 2, 3, 4, 5};
		ar[1] = new int[]{6, 7, 8, 9, 10};
		ar[2] = new int[]{11, 12, 13, 14, 15};
		ar[3] = new int[]{16, 17, 18, 19, 20};
		ar[4] = new int[]{21, 22, 23, 24, 25};
		List<Integer> spiralOrder = getSpiralOrder(ar);
		for (Integer aSpiralOrder : spiralOrder) {
			System.out.println(aSpiralOrder);
		}
	}
}
