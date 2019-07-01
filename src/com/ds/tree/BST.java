package com.ds.tree;

public class BST {
	
	private Node root;
	
	public BST() {
		root = null;
	}
	
	class Node {
		private Node lc;
		private Person data;
		private Node rc;
	}
	
	
	public boolean insert(Person item) {
		Node n = new Node();
		n.data = item;
		n.lc = null;
		n.rc = null;
		
		if(root == null) {
			root = n;
			return true;
		}
		
		Node parent = root;
		Node child = root;
		
		while(child != null ) {
			parent = child;
			
			if(item.getName().compareTo(child.data.getName()) < 0) {
				child = child.lc; 
			} else {
				child = child.rc;
			}
		}
		
		if(item.getName().compareTo(parent.data.getName()) < 0) {
			parent.lc = n;
		} else {
			parent.rc = n;
		}
		
		return true;
	}
	
	
	public Node findParentNode(String key) {
		Node parent = root;
		Node child = root;
		
		do {
			if(key.compareTo(child.data.getName()) == 0 ) {
				break;
			}
			parent = child;
			
			if(key.compareTo(child.data.getName()) < 0 ) {
				child = child.lc;
			} else {
				child = child.rc;
			}
		} while(child != null);
		
		System.out.println(" >> "+ parent.data.getName());
		
		if(child != null) {
			return parent;
		} else {
			return null;
		}
	}
	
	public Person getData(Node n) {
		return n.data;
	}
	
	
	public Node findNode(String key) {
		Node child = root;
		while(child != null) {
			if(key.compareTo(child.data.getName()) == 0 ) {
				break;
			} if(key.compareTo(child.data.getName()) < 0 ) {
				child = child.lc;
			} else {
				child = child.rc;
			}
		}
		return child;
	}
	
	public void showAll(Node n) {
		Node parent = n;
		
		if(parent != null) {
			System.out.print("" + parent.data);
			showAll(parent.lc);
			showAll(parent.rc);
		}
		
	}
	
	
}
