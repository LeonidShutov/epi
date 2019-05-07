package trees;

public class T101 {

	public static void main(String[] args) {
		Node tree = new Node(0);
		System.out.println(isBalanced(tree));
		tree = new Node(0);
		tree.left = new Node(1);
		tree.right = new Node(2);
		tree.left.left = new Node(3);
		tree.left.right = new Node(4);
		tree.right.left = new Node(5);
		tree.right.right = new Node(6);
		tree.right.right.right = new Node(7);
		System.out.println(isBalanced(tree));
		tree.right.right.right.right = new Node(8);
		System.out.println(isBalanced(tree));
	}

	private static boolean isBalanced(Node tree) {
		if (tree == null || (tree.left == null && tree.right == null)) {
			return true;
		}

		return isBalanced(tree.left) && isBalanced(tree.right) &&
				(Math.abs(height(tree.left) - height(tree.right)) <= 1);
	}

	private static int height(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
}

class Node {
	Node left;
	Node right;
	Integer data;

	public Node(Integer data) {
		this.data = data;
	}
}