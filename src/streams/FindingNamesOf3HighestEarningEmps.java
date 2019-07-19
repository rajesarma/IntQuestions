package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindingNamesOf3HighestEarningEmps {

	public static void main(String[] args) {

		List<Employee> employess = getAllEmployees();
		
		
		// Old Way
		//List<Employee> empCopy = new ArrayList<Employee>(employess);
		
		//empCopy.sort( (o1,o2) -> o2.getSalary() - o1.getSalary() ); // Sort
		
		/*for(int i=0; i< 3; i++)
		{
			Employee emp = empCopy.get(i);
			System.out.println(emp.getName());
			
		}*/
		// Old Way
		
		
		/*employess.stream()
				.sorted(Comparator.comparingLong(Employee:: getSalary).reversed() )
				.limit(3)
				//.map(emp -> emp.getName())
				.map(emp -> emp.getName()+ " "+ emp.getSalary())
				//.map( Employee::getName)
				.forEach(System.out :: println);*/
		
		// To List
		List<String> empList = employess.stream()
					.sorted(Comparator.comparingLong(Employee:: getSalary).reversed() )
					.limit(3)
					//.map(emp -> emp.getName())
					.map(emp -> emp.getName()+ " "+ emp.getSalary())
					//.map( Employee::getName)
					.collect(Collectors.toList());
		
		System.out.println(empList);
		
		Set<?> empSet = employess.stream()
				.sorted(Comparator.comparingLong(Employee:: getSalary).reversed() )
				.limit(3)
				//.map(emp -> emp.getName())
				.map(emp -> emp.getName()+ " "+ emp.getSalary())
				//.map( Employee::getName)
				.collect(Collectors.toSet());
		
		System.out.println(empSet);
		
		// To Map
		Map<String, Employee> empMap =  employess.stream()
												.collect(Collectors.toMap(e -> e. getName(), e -> e ) );
		Map<String, Long> empNameSalMap =  employess.stream()
												.collect(Collectors.toMap(e -> e.getName(), e -> e.getSalary() ) );
		
		System.out.println("empNameSalMap : "+empNameSalMap);
		
		
		// To comma seperated Strings
		String empNames =  employess.stream()
								.map(emp -> emp.getName())
								.collect(Collectors.joining(","));

		System.out.println("comma seperated Strings : "+empNames);
		
		// Group by Salary
		Map<Object, List<Employee>> empSalGroup1 =  employess.stream()
								.collect(Collectors.groupingBy( e -> e.getSalary() ));

		System.out.println(empSalGroup1);
		
		// Group by Salary Counts
		Map<Long, Long> empSalGroup2 =  employess.stream()
								.collect(Collectors.groupingBy(Employee :: getSalary, Collectors.counting() ));

		System.out.println(empSalGroup2);
		
		
		// Parallel Stream
		Map<Long, Long> empSalGroupParallel1 =  employess.stream()
				.parallel()
				.collect(Collectors.groupingBy(Employee :: getSalary, Collectors.counting() ));
		
		Map<Long, Long> empSalGroupParallel2 =  employess.parallelStream()
				.collect(Collectors.groupingBy(Employee :: getSalary, Collectors.counting() ));
				
		System.out.println(empSalGroupParallel1);
	}
	
	private static List<Employee> getAllEmployees()
	{
		Employee emp1 = new Employee("Rajesh", 100000);
		Employee emp2 = new Employee("Sarma", 80000);
		Employee emp3 = new Employee("ABC1", 60000);
		Employee emp4 = new Employee("ABC2", 60000);
		Employee emp5 = new Employee("ABC3", 50000);
		
		List empList = new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		
		return empList;
	}

}
