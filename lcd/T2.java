package lcd;

public class T2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean addOne = false;
        ListNode t = new ListNode(0);
        ListNode dummy = t;

        while (l1 != null && l2 != null) {
            int next = l1.val + l2.val + (addOne ? 1 : 0);
            int num = 0;
            if (next >= 10) {
                addOne = true;
                num = next - 10;
            } else {
                num = next;
                addOne = false;
            }
            ListNode res = new ListNode(num);
            dummy.next = res;
            l1 = l1.next;
            l2 = l2.next;
            dummy=dummy.next;
        }
        while (l1 != null) {
            int next = l1.val + (addOne ? 1 : 0);
            int num = 0;
            if (next >= 10) {
                addOne = true;
                num = next - 10;
            } else {
                num = next;
                addOne = false;
            }
            ListNode res = new ListNode(num);
            dummy.next = res;
            l1 = l1.next;
            dummy=dummy.next;
        }
        while (l2 != null) {
            int next = l2.val + (addOne ? 1 : 0);
            int num = 0;
            if (next >= 10) {
                addOne = true;
                num = next - 10;
            } else {
                num = next;
                addOne = false;
            }
            ListNode res = new ListNode(num);
            dummy.next = res;
            l2 = l2.next;
            dummy=dummy.next;
        }
        if (addOne) {
            ListNode res = new ListNode(1);
            dummy.next = res;
        }
        return t.next;
    }

    public static void main(String[] args) {
        ListNode t1=new ListNode(2);
        t1.next=new ListNode(4);
        t1.next.next=new ListNode(3);

        ListNode t2=new ListNode(5);
        t2.next=new ListNode(6);
        t2.next.next=new ListNode(4);
        ListNode res=addTwoNumbers(t1,t2);
        System.out.println(res);
    }

}
