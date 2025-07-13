package com.lakshmi.interviews.mphasis;

public class Messenger implements Runnable{

	private String name;
	public Messenger(String name) {
		this.name = name;
	}
	
	public void run() {
		message(1);
		message(2);
	}
	
	private synchronized void message(int n) {
		System.out.print(name + "-" + n + " ");
	}
	
	public static void main(String[] args) {
		new Thread(new Messenger("Wallace")).start();
		new Thread(new Messenger("Gromit")).start();
	}

}
