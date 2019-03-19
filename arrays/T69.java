package arrays;

import java.util.ArrayList;
import java.util.List;

public class T69 {
	public static List<Integer> primes(int n) {
		List<Integer> res = new ArrayList<>();
		if (n < 1) {
			return res;
		}
		if (n == 1) {
			res.add(1);
			return res;
		}
		res.add(2);
		for (int i = 3; i <= n; i++) {
			for (int j = 0; j < res.size(); j++) {
				if (i % res.get(j) == 0) {
					break;
				}
				if (j == res.size() - 1) {
					res.add(i);
				}
			}
		}
		res.add(1);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(primes(18).toString());
		System.out.println(primes(1000).toString());
	}
}