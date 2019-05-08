package trees;

import java.util.ArrayList;
import java.util.List;

public class T103 {

	public static void main(String[] args) {
		Node tree = new Node(0);
		tree.left = new Node(1);
		tree.right = new Node(2);
		tree.left.left = new Node(3);
		tree.left.right = new Node(4);
		Node node0 = new Node(5);
		tree.right.left = node0;
		tree.right.right = new Node(6);
		Node node1 = new Node(7);
		tree.right.right.right = node1;
		tree.right.right.right.right = new Node(8);
		System.out.println(lca(tree, node0, node1));
	}

	private static Node lca(Node root, Node node0, Node node1) {
		List<Node> path0 = getPath(root, node0);
		List<Node> path1 = getPath(root, node1);
		return getLca(path0, path1);
	}

	private static Node getLca(List<Node> path0, List<Node> path1) {
		Node res = path0.get(0);
		for (int i = 0; i < Math.min(path0.size(), path1.size()); i++) {
			if (path0.get(i).equals(path1.get(i))) {
				res = path0.get(i);
			} else {
				break;
			}
		}
		return res;
	}

	private static List<Node> getPath(Node root, Node node) {
		List<Node> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		if (root.equals(node)) {
			result.add(root);
			return result;
		}
		List<Node> pathLeft = getPath(root.left, node);
		if (!pathLeft.isEmpty()) {
			result.addAll(pathLeft);
		}
		List<Node> pathRight = getPath(root.right, node);
		if (!pathRight.isEmpty()) {
			result.addAll(pathRight);
		}
		if (!result.isEmpty()) {
			result.add(0, root);
		}
		return result;
	}

	static class Node {
		Node left;
		Node right;
		Integer data;

		public Node(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node{" + "left=" + left + ", right=" + right + ", data=" + data + '}';
		}
	}

}
