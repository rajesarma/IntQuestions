package com.lakshmi.ds.queue;

public class QueueTest {

	public static void main(String[] args) {
		QueueUsingTwoStacks q = new QueueUsingTwoStacks();
		Object item;
		q.enQueue('A');
		q.enQueue('B');
		q.enQueue('C');
		q.show();
		System.out.println("Queue size: " + q.size());
		item = q.deQueue(); // delete item
		System.out.println(item + " is deleted");
		item = q.deQueue();
		System.out.println(item + " is deleted");
		q.show();
		System.out.println("Queue size: " + q.size());
		q.enQueue('D'); // enQueue 3 more items
		q.enQueue('E');
		q.enQueue('F');
		
		q.show();
		System.out.println("Queue size: " + q.size());
		item = q.deQueue();
		System.out.println(item + " is deleted");
		q.show();
		System.out.println("Queue size: " + q.size());
		System.out.println("peek(): " + q.peek());
		q.enQueue('G');
		q.show();
		System.out.println("Queue size: " + q.size());
	}

}
