package stacks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class T91 {
	Stack<Integer> stack= new Stack<>();
	Queue<Integer> q= new PriorityQueue<>(Comparator.comparingInt(value -> (int) value).reversed());

	public void push(Integer elem) {
		stack.push(elem);
		q.offer(elem);
	}

	public Integer pop() {

		Integer pop = stack.pop();
		q.remove(pop);
		return pop;
	}

	public Integer peek() {
		return stack.peek();
	}

	public Integer max() {
		return q.peek();
	}

	public static void main(String[] args) {
		T91 maxStack = new T91();
		maxStack.push(4);
		maxStack.push(7);
		maxStack.push(1);
		System.out.println(maxStack.max());//7
		System.out.println(maxStack.pop());//1
		System.out.println(maxStack.pop());//7
		System.out.println(maxStack.max());//4
		System.out.println(maxStack.peek());//4
	}
}
