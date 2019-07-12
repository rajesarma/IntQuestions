package interview.mphasis;

import java.util.HashSet;

class Person {
	private final String name;
	public Person(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}

public class Group extends HashSet<Person>{

	public static void main(String[] args) {
		Group g = new Group();
		
		Person p1 = new Person("Hans");
		Person p2 = new Person("Lotte");
		Person p3 = new Person("Jane");
		Person p4 = new Person("Hans");
		Person p5 = new Person("Jane");
//		System.out.println(p1.equals(p4) + " " + p1.hashCode() + " "+ p4.hashCode());
		
		g.add(p1);
		g.add(p2);
		g.add(p3);
		g.add(p4);
		g.add(p5);
		System.out.println("Total : "+ g.size());
	}
	
	@Override
	public boolean add(Person o) {
		System.out.println("Adding : "+o);
		return super.add(o);
	}
	
	//	This is actual, This wont compile
	/*public boolean add(Object o) {
		System.out.println("Adding : "+o);
		return super.add(o);
	}*/

}
