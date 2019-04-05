package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortDigits {
	public static int sortNumber(int k) {
		if (k<10) {
			return k;
		}
		List<Integer> a=new ArrayList<>();
		while (k!=0){
			a.add((k%10));
			k=k/10;
		}
		a.sort(Comparator.reverseOrder());
		for (Integer i : a) {
			k=i+k*10;
		}
		return k;
	}

	public static void main(String[] args) {
		System.out.println(sortNumber(123458456));
		System.out.println(sortNumber(5));
		System.out.println(sortNumber(45673545));
	}
}
