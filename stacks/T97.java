package stacks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T97 {

	public static List<List<Integer>> levelOrder(Node node) {
		List<List<Integer>> res = new ArrayList<>();
		if (node == null) {
			return res;
		}
		Queue<Node> q1 = new LinkedList<>();
		q1.offer(node);
		while (true) {
			List<Integer> level = new ArrayList<>();
			Queue<Node> q2 = new LinkedList<>();

			while (!q1.isEmpty()) {
				Node poll = q1.poll();
				level.add(poll.data);
				q2.addAll(poll.children);
			}
			res.add(level);
			if (q2.isEmpty()) {
				return res;
			}
			q1.addAll(q2);
		}
	}

	public static void main(String[] args) {
		Node node = new Node(5);
		node.children.add(new Node(6));
		Node e = new Node(7);
		e.children.add(new Node(2));
		e.children.add(new Node(3));
		e.children.add(new Node(4));
		node.children.add(e);
		Node e1 = new Node(8);
		e1.children.add(new Node(9));
		Node e2 = new Node(0);
		e2.children.add(new Node(11));
		e1.children.add(e2);
		node.children.add(e1);
		List<List<Integer>> lists = levelOrder(node);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}

class Node {
	List<Node> children = new ArrayList<>();
	Integer data;

	public Node(Integer data) {
		this.data = data;
	}
}
