package com.lakshmi.ds.queue;

public class QueueOld {
	
	private int maxSize;
	private int front;
	private int rear;
	private int count;
	private Object[] elements;
	
	public QueueOld(int maxSize ) {
		this.maxSize = maxSize; 
		elements = new Object[maxSize];
		front = rear = -1;
		count = 0;
	}
	
	public void enQueue(Object item) {
		if(count == maxSize) {
			System.out.println(" Queue is Full");
			 return;
		}
		
		if((rear == maxSize - 1) || (rear == -1)) {
			elements[0] = item;
			rear = 0;
			
			if(front == -1) {
				front = 0;
			}
		} else {
			elements[++rear] = item;
		}
		
		count ++;
	}
	
	public Object deQueue() {
		if(isEmpty()) {
			System.out.println(" Queue is Empty");
			return 0;
		}
		
		Object tmp = elements[front];
		elements[front] = null;
		
		if(front == rear) {
			rear = front = -1;
		} else if(front == maxSize -1) {
			front = 0;
		} else {
			front ++;
		}
		
		return tmp;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public Object peek() {
		return elements[front];
	}
	
	public int size() {
		return count;
	}
	
	public void show() {
		for(int i=0; i < maxSize; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}
	
	

}
