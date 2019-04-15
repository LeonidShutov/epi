package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MergeKArrays {
	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int len = 0;
		int k = Integer.parseInt(r.readLine());
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			String[] curAr=r.readLine().split(" ");
			int n = Integer.parseInt(curAr[0]);
			len += n;
			int[] ar = new int[n];
			for (int j = 0; j < n; j++) {
				ar[j] = Integer.parseInt(curAr[j+1]);
			}
			list.add(ar);
		}
		int[] curIndexes = new int[k];
		int curArWMin=0;
		for (int i = 0; i < len; i++) {
			int curEl = Integer.MAX_VALUE;
			for (int j = 0; j < k; j++) {
				int[] curAr = list.get(j);
				if (curAr.length>curIndexes[j]) {
					int curVal = curAr[curIndexes[j]];
					if (curEl > curVal) {
						curEl = curVal;
						curArWMin = j;
					}
				}
			}
			System.out.print(curEl+" ");
			curIndexes[curArWMin]++;
		}
	}
}
