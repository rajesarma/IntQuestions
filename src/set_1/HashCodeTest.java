package set_1;

public class HashCodeTest {

	public static void main(String... cmd) {
		
		/*double salary = 10;
		long temp = Double.doubleToLongBits(salary);
		long temp1 = Double.doubleToLongBits(salary);
		
		System.out.println(temp);
		
		temp = temp >>> 32;
		
		System.out.println(temp);
		
		temp1 = (temp1 ^ (temp1 >>> 32));
		
		System.out.println(temp1);*/
		
		//int result = (int) (temp ^ (temp >>> 32));
		
		
	}
	
	
	
	
	private static class Employee {
		int empId = 101;
		String empName = "Sreedhar";
		double salary = 50000;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + empId;
			result = prime * result + ((empName == null) ? 0 : empName.hashCode());
			long temp;
			temp = Double.doubleToLongBits(salary);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (empId != other.empId)
				return false;
			if (empName == null) {
				if (other.empName != null)
					return false;
			} else if (!empName.equals(other.empName))
				return false;
			if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
				return false;
			return true;
		}
		
		
	}
	
	
}
