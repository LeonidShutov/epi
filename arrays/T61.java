package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T61 {
	public static Integer[] dutch(Integer[] arr, int x) {
		List<Integer> a=Arrays.asList(arr);
		int lessI = 0;
		int eqIStart = x;
		int greatI = a.size()- 1;
		int p = a.get(x);
		while ( eqIStart < greatI) {
			if (a.get(lessI) < p) {
				Collections.swap(a , lessI++, x++);
			} else if (a.get(lessI) == p) {
				++eqIStart;
			} else {
				Collections.swap(a , eqIStart, --greatI);
			}
		}
		return a.toArray(new Integer[0]);
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1, 4, 2, 7, 1, 2, 3};
		final Integer[] dutch = dutch(arr, 5);
		System.out.println(Arrays.toString(dutch));
	}
}
