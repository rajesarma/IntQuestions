package com.lakshmi.com.ds.linkedlist;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.insertAtEnd(12);
		ls.insertAtEnd(45);
		ls.insertAtEnd(56);
		ls.insertAtEnd(72);
		
		ls.show();
		
		System.out.println("------------");
		ls.insertAtStart(10);
		
		ls.show();
		
		System.out.println("------------");

		ls.insertAt(3,50);
		
		ls.show();
		
		System.out.println("------------");

		/*ls.insertAt(0,100);
		
		ls.show();
		*/
		
		System.out.println("------------");

		ls.deleteAt(3);
		
		ls.show();
	}

}
