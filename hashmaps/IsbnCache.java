package hashmaps;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsbnCache {
	private Map<String, Integer> map;
	private Deque<String> deque;
	private int size;

	public IsbnCache(int size) {
		this.size = size;
		map = new HashMap<>(size);
		deque = new LinkedList<>();
	}

	public Integer lookup(String isbn) {
		if (deque.remove(isbn)) {
			deque.addFirst(isbn);
		}
		return map.getOrDefault(isbn, null);
	}

	public Integer remove(String isbn) {
		if (!map.containsKey(isbn)) {
			return null;
		}
		deque.remove(isbn);
		Integer removed = map.get(isbn);
		map.remove(isbn);
		return removed;
	}

	public void insert(String isbn, Integer price) {
		if (!map.containsKey(isbn) && map.size() >= size) {
			String last = deque.getLast();
			deque.removeLast();
			map.remove(last);
		}
		if (map.containsKey(isbn)) {
			deque.remove(isbn);
			deque.addFirst(isbn);
		} else {
			map.put(isbn, price);
			deque.addFirst(isbn);
		}
	}

	public static void main(String[] args) {
		IsbnCache cache = new IsbnCache(2);
		cache.insert("z", 4);
		cache.insert("y", 6);
		cache.insert("z", 3);
		cache.insert("t", 2);
		System.out.println(cache.lookup("y"));//null
		System.out.println(cache.lookup("z"));//4
		System.out.println(cache.lookup("t"));//2
		System.out.println(cache.remove("z"));//4
		System.out.println(cache.lookup("z"));//null
	}
}
