package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxConseqOnes {

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(r.readLine());
		int result = 0;
		int cur = 0;
		for (int i = 0; i < n; i++) {
			int c = Integer.valueOf(r.readLine());
			if (c == 1) {
				cur++;
			} else {
				if (cur > result) {
					result = cur;
				}
				cur = 0;
			}
		}
		if (cur>result)
			result=cur;
		System.out.println(result);
	}
}

