package com.ds.queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue q = new Queue(5);
		Object item;
		q.enQueue('A'); 
		q.enQueue('B'); 
		q.enQueue('C'); 
		q.show();
		item = q.deQueue(); // delete item
		System.out.println(item + " is deleted");
		item = q.deQueue();
		System.out.println(item + " is deleted");
		q.show();
		q.enQueue('D'); // enQueue 3 more items
		q.enQueue('E');
		q.enQueue('F');
		
		q.show();
		item = q.deQueue();
		System.out.println(item + " is deleted");
		q.show();
		System.out.println("peek(): " + q.peek());
		q.enQueue('G');
		q.show();
		System.out.println("Queue size: " + q.size());
		
	}

}
