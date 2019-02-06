package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T65 {
	public static int deduplicate(List<Integer> a) {
		int res = 1;

		for (int i = 1; i < a.size(); ++i) {
			if (!a.get(res - 1).equals(a.get(i))) {
				a.set(res++, a.get(i));
			}
		}
		System.out.println(a);
		return res;
	}

	public static void main(String[] args) {
		Integer[] ar = new Integer[]{2, 3, 5, 5, 7, 11, 11, 11, 13};
		System.out.println(deduplicate(new ArrayList<>(Arrays.asList(ar))));
	}
}