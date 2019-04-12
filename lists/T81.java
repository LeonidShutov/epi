package lists;

public class T81 {

	private static Node mergeLists(Node n1, Node n2) {
		Node dummy = new Node(0);
		Node res = dummy;
		if (n1 == null) {
			return n2;
		}
		if (n2 == null) {
			return n1;
		}
		while (n1 != null && n2 != null) {
			if (n1.data > n2.data) {
				dummy.next = n2;
				n2 = n2.next;
			} else {
				dummy.next = n1;
				n1 = n1.next;
			}
			dummy=dummy.next;
		}
		while(n1!=null){
			dummy.next=n1;
			n1=n1.next;
			dummy=dummy.next;
		}
		while(n2!=null){
			dummy.next=n2;
			n2=n2.next;
			dummy=dummy.next;
		}
		return res.next;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.next = new Node(4);
		n1.next.next = new Node(7);
		n1.next.next.next = new Node(10);
		n1.next.next.next.next = new Node(100);
		n1.next.next.next.next.next = new Node(200);
		n1.next.next.next.next.next.next = new Node(300);

		Node n2 = new Node(2);
		n2.next = new Node(3);
		n2.next.next = new Node(5);
		n2.next.next.next = new Node(12);
		n2.next.next.next.next = new Node(15);
		n2.next.next.next.next.next = new Node(17);
		System.out.println(n1);
		System.out.println(n2);

		Node merged = mergeLists(n1, n2);
		System.out.println(merged);
	}

	static class Node {
		Node next;
		Integer data;

		public Node(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node{" + "next=" + next + ", data=" + data + '}';
		}
	}
}

