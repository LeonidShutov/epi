package search;

import java.util.PriorityQueue;
import java.util.Queue;

public class T128 {
	private static int findKLargest(int[] ar, int k) {
		if (ar.length < k) {
			return -1;
		}
		Queue<Integer> q = new PriorityQueue<>(k);
		for (int i : ar) {
			if (q.size() < k) {
				q.offer(i);
			} else {
				Integer poll = q.poll();
				if (poll != null && poll > i) {
					q.offer(poll);
				} else {
					q.offer(i);
				}
			}
		}

		return q.isEmpty() ? -1 : q.poll();
	}

	public static void main(String[] args) {
		int k = 4;
		int[] ar = {3, 1, 2, 5, 4};
		System.out.println(findKLargest(ar, k));
	}
}
