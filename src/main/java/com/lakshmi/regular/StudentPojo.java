package com.lakshmi.regular;

public class StudentPojo {
 String name ="asdf";
 int age =23;
}
class PersonPojo {
	
	private  String name ="asdf";
	private  int age =23;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age+"";
	}
	public void setAge(String age) {
		
		this.age = Integer.parseInt(age);
	}
	
	
	}