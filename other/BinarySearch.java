package other;

public class BinarySearch {
	public static int binarySearch(int[] a, int x) {
		int left = 0;
		int right = a.length;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (a[mid] == x) {
				return mid;
			}
			if (a[mid] > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 5, 6, 8, 12, 17, 22};
		System.out.println(binarySearch(a, 5));
		System.out.println(binarySearch(a, 3));
		System.out.println(binarySearch(a, -8945));
		System.out.println(binarySearch(a, 22));
		System.out.println(binarySearch(a, 1));
		System.out.println(binarySearch(a, 17));
	}
}
