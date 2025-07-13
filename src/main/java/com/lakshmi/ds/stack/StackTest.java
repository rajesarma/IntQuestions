package com.lakshmi.ds.stack;

public class StackTest {

	public static void main(String[] args) {
//		Stack stack = new Stack();
		DynamicStack stack = new DynamicStack();
		
		System.out.println("isEmpty : "+stack.isEmpty());
		
		stack.push(10);
		stack.show();
		stack.push(20);
		stack.show();
		stack.push(30);
		stack.show();
		stack.push(40);
		stack.show();
		stack.push(50);
		stack.show();
		stack.push(60);
		stack.show();
		
		stack.pop();
		
		stack.show();
		
		System.out.println("Size : "+stack.size());
		System.out.println(stack.peek());
		
		/*stack.show();
		
		System.out.println("Size : "+stack.size());
		System.out.println("isEmpty : "+stack.isEmpty());*/
	}

}

