package regular;

public class TestAbstration {
	public static void main(String[] args) {
		StudentPojo student = new StudentPojo();
		student.age=12;
		student.name="aasdf";
		
		PersonPojo person = new PersonPojo();
		person.setAge("23");
		String age = person.getAge();
		person.setName("asdfasdf");
		
	} 
}
