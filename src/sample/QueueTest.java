package sample;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<String>();
		
		q.add("B");
		q.add("A");
		
		System.out.println(q.peek());
		
		
		
		
	}
	
}
