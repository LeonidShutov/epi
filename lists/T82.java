package lists;

public class T82 {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		n1.next.next.next.next = new Node(5);
		n1.next.next.next.next.next = new Node(6);
		n1.next.next.next.next.next.next = new Node(7);
		System.out.println(n1);
		Node res=reversePart(n1,2,5);
		System.out.println(res);
	}

	private static Node reversePart(Node n1, int s, int f) {
		Node prev=n1;
		Node cur;
		//move to start
		for (int i=1;i<s;i++){
			prev=n1.next;
		}
		cur=prev.next;

		//reverse until finish
		for (int i=s;i<f;i++){
			Node temp=cur.next;
			cur.next=temp.next;
			temp.next=prev.next;
			prev.next=temp;
		}
		return n1;
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
