package ds.queue;

public class CircularQueueTest {

	public static void main(String[] args) {
		CircularQueueOld queue = new CircularQueueOld(5);
		
//		System.out.println(queue.isEmpty());
		
		queue.enQueue(5);
		queue.enQueue(10);
		queue.enQueue(15);
		queue.enQueue(20);
		
		queue.show();
		
		queue.deQueue();
		queue.deQueue();
		
		queue.enQueue(25);
		queue.enQueue(30);
		queue.enQueue(35);
		queue.enQueue(40);
		
		System.out.println();
		queue.show();
		
		queue.deQueue();
		queue.deQueue();
		
		System.out.println();
		queue.show();
		
		System.out.println();
//		System.out.println("Size : " + queue.getSize());
//		System.out.println(queue.isFull());
		
		for(int i=0; i < queue.elements().length; i++) {
			System.out.print(queue.elements()[i] + " ");
		}
		
	}

}
