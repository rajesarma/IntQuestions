package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}

public class SerailizeTest {

	
	public static void main(String[] args) {
		Employee emp = new Employee();
		
		emp.setName("Raj");
		emp.setSalary(100000);
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
		fos = new FileOutputStream("Employee.ser");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(emp);
		
		oos.close();
		fos.close();
		
		} catch(IOException e) {
			
		} finally {
			
		}
		
		System.out.println("Name : "+ emp.getName());
		System.out.println("Salary : "+ emp.getSalary());
	}
}
