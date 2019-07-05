package lambda;

import java.util.function.Function;

class Power{
	
	public double square(double num) {
		
		return Math.pow(num, 2);
		
	}
	
}

public class DoubleColonTest {

	public static void main(String[] args) {
	
		Function<Double, Double> ans = ( d -> Math.pow(d, 2) );
		System.out.println(ans.apply(23.12) );
		
		
		Power power = new Power();
		Function<Double, Double> ans1 = power::square;
		System.out.println(ans1.apply(23.12) );
		
	}
	
	
}
