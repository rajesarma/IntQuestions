package com.ds.stack;

public class DynamicStack {
	
	int capacity = 2;
	int[] stack = new int[capacity];
	int top = 0;
	
	public void push(int data) {
		if (size() == capacity) {
			expand();
			
		} else {
			stack[top] = data;
			top++;
		}
	}
	
	public int pop() {
		int data = 0;
		
		if (isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			
			top--;
			data = stack[top];
			stack[top] = 0;
			shrink();
		}
		return data;
	}
	
	public int peek() {
		return stack[top - 1];
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return (top <= 0) ;
	}
	
	public boolean isFull() {
		return (top == capacity) ;
	}
	
	public void show() {
		for(int n : stack) {
			System.out.print(n+", ");
		}
		System.out.println();
	}
	
	public void expand() {
		
		int length = size();
		int[] newStack = new int[capacity * 2];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		capacity *= 2;
	}
	
	
	public void shrink() {
		
		int length = size();
		
		if(length <= (capacity/2) /2 ) 
			capacity = capacity / 2;
		
		int[] newStack = new int[capacity];
		
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
	}
	
}
