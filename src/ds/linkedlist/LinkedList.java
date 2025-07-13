package com.ds.linkedlist;

public class LinkedList {
	Node head;
	
	public void insertAtEnd(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head == null) {
			head = node;
		} else {
			Node n = head;
			while(n.next != null) {
				
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public void insertAt(int index, int data) {
		
		if(index == 0) {
			insertAtStart(data);
		}
		else {
			
			Node node = new Node();
			node.data = data;
			node.next = null;
			
			Node n = head;
			
			for(int i=0; i < index-1; i++) {
				
				n = n.next;
			}
			
			node.next = n.next;
			n.next = node;
		}
	}
	
	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
	}
	
	public void deleteAt(int index) {
		
		if(index == 0) {
			head = head.next;
		}
		else {
			Node n = head;
			for(int i=0; i < index-1; i++) {
				
				n = n.next;
			}
			Node nodeToDelete = n.next;
			n.next = nodeToDelete.next;
			nodeToDelete = null;
		}
	}
	
	
	public void show() {
		
		Node n = head;
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
}
