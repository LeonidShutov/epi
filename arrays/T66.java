package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T66 {
	public static int buySellStock(List<Integer> a) {
		if (a.isEmpty()) {
			return 0;
		}
		int res = 0;
		int curBuy = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			res = Math.max(res, a.get(i) - curBuy);
			curBuy = Math.min(curBuy, a.get(i));
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] ar = new Integer[]{310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		System.out.println(buySellStock(new ArrayList<>(Arrays.asList(ar))));
	}
}