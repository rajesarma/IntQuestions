package regular;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

class Student implements Cloneable,Externalizable{
	static String name="ac";
	transient String dob="12/12/12";
	Address add  = null;
	
	Student(String name , String dob)
	 {
		 this.name=name;
		 this.dob=dob;
	 }
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Student std =(Student) super.clone();
		Address add =(Address) std.add.clone();
		std.add=add;
		return std;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("readExternal");
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
	   System.out.println("writeExternal");
		
	}
	
	
	
}
class Address implements Cloneable,Externalizable{
	String street;
	String area;
	Address(String street,	String area)
	{
		this.street=street;
		this.area=area;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Address::readExternal");
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Address::writeExternal");
		
	}
	
}

public class CloneTest {

	public static void main1(String[] args) {
		A a = new A();
		a.i=10;
		
		A a2 =a;
		a2.i=90;
		
		System.out.println(a.i);
	}
	public static void main(String[] args) {
		Student std  =new Student("Chiranjeevi","1947");
		Address add =  new Address("Sr Nagar", "Ammerpet");
		std.add=add;
		
		try {
		Student std2 =	(Student)std.clone();
		std2.name="Balakrishna";
		std2.add.street="kphb";
		std2.add.area="kukatpally";
		
		System.out.println("cloned data:");
		System.out.println(std2.dob+"::"+std2.name+"::"+std2.add.area+"::"+std2.add.street );
		
		
		
		System.out.println("original data:");
		System.out.println(std.dob+"::"+std.name+"::"+std.add.area+"::"+std.add.street);
		/*std2.name="Balakrishna";
		
		System.out.println(std.name);*/
		
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testclone()
	{
		Student std  =new Student("Chiranjeevi","1947");
		std.getClass();
	}
}
