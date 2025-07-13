package com.lakshmi.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Person{
	
	Person(String firstName, String lastName, int age){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		
	}
	
	private String firstName;
	private String lastName;
	private int age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "[First Name : "+firstName+", Last Name : "+lastName+", Age : "+firstName+" ]";
	}
	
}



public class LambdaEmaple1 {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Lakshmi", "Sridhar", 22),
				new Person("Lakshmi", "Rajeswara Rao", 35),
				new Person("Durga", "Prasad", 24),
				new Person("Kumara", "Swamy", 24),
				new Person("Manoj", "Kumar", 24)
				);
				
		// Java 7
			/*Collections.sort(persons, new Comparator<Person>() {
				@Override
				public int compare(Person p1, Person p2) {
					return p1.getLastName().compareTo(p2.getLastName());
				}
			});*/
			
			
			
			//printNamesStatsWithL(persons);
			
			/*printByCondition(persons, new Condition() {
				
				@Override
				public boolean test(Person p) 
				{
					return p.getFirstName().startsWith("M");
				}
			});*/
		// Java 7
			
			
		// Java 8
			Collections.sort(persons, (p1, p2) -> p2.getLastName().compareTo(p1.getLastName()) );
			
			printByCondition(persons, (p) -> p.getFirstName().startsWith("M") );
			
			printByCondition(persons, (p) -> p.getFirstName().startsWith("K") );
			
			printByCondition(persons, p -> true);	// Print all
			
			printConditionally(persons, p -> true, p -> System.out.println(p.getFirstName()));
			
	}
	
	public static void printAll(List<Person> persons) {
		
		for(Person p : persons)
		{
			System.out.println(p.toString());
		}
	}
	
	public static void printNamesStatsWithL(List<Person> persons) {
		
		for(Person p : persons)
		{
			if(p.getFirstName().startsWith("L"))
				System.out.println(p.toString());
		}
	}
	
	public static void printByCondition(List<Person> persons, Condition condition) {
		
		for(Person p : persons)
		{
			if(condition.test(p))
				System.out.println(p.toString());
		}
	}
	
	//Here we need not to create any interface
	public static void printByCondition1(List<Person> persons, Predicate<Person> condition) {
		
		for(Person p : persons)
		{
			if(condition.test(p))
				System.out.println(p.toString());
		}
	}
	
	public static void printConditionally(List<Person> persons, Predicate<Person> condition, Consumer<Person> consumer) {
		
		for(Person p : persons)
		{
			if(condition.test(p))
				consumer.accept(p);
		}
	}
}

interface Condition{
	boolean test(Person p);
	
}





