package search;

public class T124 {
	private static int findRoot(int x) {
		long left = 0;
		long right = x;
		while (left <= right) {
			long mid = left + ((right - left) / 2);
			long ms = mid * mid;
			if (ms <= x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return (int) left - 1;
	}

	public static void main(String[] args) {
		int x = 2000000000;
		System.out.println(findRoot(x));
	}
}
