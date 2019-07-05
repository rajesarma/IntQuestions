package generics;

class A implements Comparable<A>{

	@Override
	public int compareTo(A o) {
		return 0;
	}
}

public class MaxTest {

	public static <T extends Comparable<T>> T max(T x,T y, T z ) {
		T max = x;
		
		if(y.compareTo(max) > 0)
			max = y;
		if(z.compareTo(max) > 0)
			max = z;
		
		return max;
	}
	
	public static int maximum(int i, int j, int k)
	{
		if(i>j && i>k)
			return i;
		else if(j>i && j>k)
			return j;
		else
			return k;
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(max(1,2,3));
		
		System.out.println(max("abc", "acb" , "bca"));
		
		System.out.println(max(1.1,2.2,3.1));
		
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		
		System.out.println(max(a1,a2,a3));
		
	}
	
}
