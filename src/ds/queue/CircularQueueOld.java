package ds.queue;

public class CircularQueueOld {
	
	int maxSize;
	int[] queue;
	int count;
	int front;
	int rear;
	
	CircularQueueOld(int maxSize) {
		this.maxSize = maxSize;
		queue = new int[maxSize];
	}

	public void enQueue(int data) {
		
		if(!isFull()) {
			queue[rear] = data;
			rear = (rear + 1) % maxSize;
			count = count + 1;
		} else {
			System.out.println("Queue is Empty");
		}
	}
	
	public int deQueue() {
		
		int data = queue[front];
		if(!isEmpty()) {
			
			front = (front  + 1) % maxSize;
			count = count - 1;
		} else {
			System.out.println("Queue is Full");
		}
		
		return data;
	}
	
	public void show() {
		
		for(int i=0; i < count; i++) {
			System.out.print(queue[(front + i) % maxSize] + " ");
		}
	}
	
	public int[] elements() {
		
		int[] elements = new int[count];
		for(int i=0; i < count; i++) {
			elements[i] = queue[(front + i) % maxSize];
		}
		
		return elements;
	}
	
	public int getSize() {
		return count;
	}
	
	public boolean isEmpty() {
		
		return getSize() == 0;
	}
	
	public boolean isFull() {
		
		return getSize() >= maxSize;
	}
	
}
