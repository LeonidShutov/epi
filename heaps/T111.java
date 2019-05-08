package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class T111 {
	private static List<Integer> combine(List<List<Integer>> lists) {
		List<Iterator<Integer>> iterators = new ArrayList<>(lists.size());

		for (List<Integer> list : lists) {
			iterators.add(list.iterator());
		}
		Queue<ArrayEntry> queue = new PriorityQueue<>(lists.size(), Comparator.comparingInt(o -> o.value));
		for (int i = 0; i < iterators.size(); i++) {
			if (iterators.get(i).hasNext()) {
				queue.add(new ArrayEntry(iterators.get(i).next(), i));
			}
		}
		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			ArrayEntry poll = queue.poll();
			res.add(poll.value);
			if (iterators.get(poll.arrayId).hasNext()) {
				queue.add(new ArrayEntry(iterators.get(poll.arrayId).next(), poll.arrayId));
			}
		}
		return res;
	}

	private static class ArrayEntry {
		Integer value;
		Integer arrayId;

		ArrayEntry(Integer value, Integer arrayId) {
			this.value = value;
			this.arrayId = arrayId;
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(Arrays.asList(3, 5, 7));
		lists.add(Arrays.asList(0, 6));
		lists.add(Arrays.asList(0, 6, 28));
		System.out.println(combine(lists));
	}
}
