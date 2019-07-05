package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class OlaDriver{
	private String name;
	private int noOfTrips;
	
	OlaDriver(String name, int noOfTrips) {
		this.name = name;
		this.noOfTrips = noOfTrips;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfTrips() {
		return noOfTrips;
	}
	public void setNoOfTrips(int noOfTrips) {
		this.noOfTrips = noOfTrips;
	}

	@Override
	public String toString() {
		return "OlaDriver [name=" + name + ", noOfTrips=" + noOfTrips + "]";
	}
	
	
}

public class OlaNoOfTrips {

	public static void main(String[] args) {
		
		OlaDriver ola1 = new OlaDriver("A", 10);
		OlaDriver ola2 = new OlaDriver("B", 5);
		OlaDriver ola3 = new OlaDriver("C", 10);
		OlaDriver ola4 = new OlaDriver("D", 5);
		OlaDriver ola5 = new OlaDriver("F", 10);
		
		List<OlaDriver> drivers = new ArrayList<>();
		drivers.add(ola1);
		drivers.add(ola2);
		drivers.add(ola3);
		drivers.add(ola4);
		drivers.add(ola5);
		
		drivers.sort(Comparator.comparing(OlaDriver::getNoOfTrips).reversed().thenComparing(OlaDriver::getName) );
		
//		Collections.sort(drivers, Comparator.comparing(OlaDriver::getNoOfTrips).reversed().thenComparing(OlaDriver::getName));
		
		drivers.forEach(System.out :: print);
	}

}
