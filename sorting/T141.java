package sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T141 {
	private static List<Integer> intersect(int[] a, int[] b) {
		Set<Integer> res = new HashSet<>();
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				res.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}

		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		int[] a = {2, 3, 3, 5, 5, 6, 7, 7, 8, 12};
		int[] b = {5, 5, 6, 8, 8, 9, 10, 10};
		System.out.println((intersect(a, b).toString()));
	}
}
