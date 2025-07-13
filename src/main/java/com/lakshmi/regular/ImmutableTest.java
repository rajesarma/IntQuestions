package com.lakshmi.regular;

class ImmutablePojo
{
	private String name="";
	private String dob="";
	
	public ImmutablePojo setName(String name) {
		ImmutablePojo pojo=null;
		try {
			pojo = 
					new ImmutablePojo(name, dob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pojo;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public ImmutablePojo(String name, String dob) throws Exception
	{
		this.name=name;
		this.dob=dob;
	}
	public String getName() {
		return name;
	}
	
	public String getDob() {
		return dob;
	}
	
	
	
}
public class ImmutableTest {

	public static void main(String[] args) {
		 try {
			ImmutablePojo pojo = new ImmutablePojo("A","12/12/12");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	  
	}
}
