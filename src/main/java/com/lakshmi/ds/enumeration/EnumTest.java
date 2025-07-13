package com.lakshmi.com.ds.enumeration;

public class EnumTest {
	
	enum TrafficSignal {
		RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN");
		
		private String action = "";
		
		private TrafficSignal(String action) {
			this.action = action;
		}

		public String getAction() {
			return action;
		}
	}

	enum Color {
		RED, GREEN, BLUE;
		
		private Color(){
			System.out.println("Constructor called for "+ this.toString());
		}
		
		public void colorInfo() {
			System.out.println("Universal Color");
		}
	}
	
	public static void main(String[] args) {
		Color color = Color.GREEN;
		
		System.out.println(color);	// Shows GREEN here
		System.out.println("Ordinal means index : "+color.ordinal());
		color.colorInfo();
		
		System.out.println(Color.valueOf("RED"));
		
		Color[] colors = Color.values();
		
		for(Color color1 : colors) {
			System.out.println(color1);
		}
		
		TrafficSignal[] signals = TrafficSignal.values();
		
		for(TrafficSignal signal : signals) {
			System.out.println(signal+ " -> "+signal.getAction());
		}
		
		
		
		
	}

}
