package com.lakshmi.sample;

import java.util.ArrayList;


public class TestMainClass {

	public static void main(String[] args) {
		
		TestMainClass t = new TestMainClass();   
		Commodities c =  t.new Commodities();
		
		System.out.println(c.getCommodities());
		
		for(int row = 0; row < c.getCommodities().size(); row++)
		{
			System.out.println(c.getCommodities().get(row).commCode);
			System.out.println(c.getCommodities().get(row).commName);
			System.out.println(c.getCommodities().get(row).commUnits);
		}
	}

	class Commodities{
		
		public ArrayList<Commodity> getCommodities() {
			
			ArrayList<Commodity> commodityList = new ArrayList<Commodity>();
			
			Commodity comm1 = new Commodity();
			comm1.setCommCode("2202021");
			comm1.setCommName("Wheat");
			comm1.setCommUnits("Kls");
			commodityList.add(comm1);
			
			Commodity comm2 = new Commodity();
			comm2.setCommCode("2202022");
			comm2.setCommName("Rice");
			comm2.setCommUnits("Mts");
			commodityList.add(comm2);
			
			return commodityList;
		}
	}
	
	
	
	class Commodity
	{
		private String commCode;
		private String commName;
		private String commUnits;
		public String getCommCode() {
			return commCode;
		}
		public void setCommCode(String commCode) {
			this.commCode = commCode;
		}
		public String getCommName() {
			return commName;
		}
		public void setCommName(String commName) {
			this.commName = commName;
		}
		public String getCommUnits() {
			return commUnits;
		}
		public void setCommUnits(String commUnits) {
			this.commUnits = commUnits;
		}
	}

}
