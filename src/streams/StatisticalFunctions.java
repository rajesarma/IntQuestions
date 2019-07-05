package streams;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

public class StatisticalFunctions {

	public static void main(String[] args) {
		
		int[] nums = {10,5,2,8,3,6,4};
		
		// Old way
		int minValue = nums[0];
		for(int i=1; i< nums.length; i++)
		{
			if(minValue>nums[i]) {
				minValue = nums[i];
			}
		}
		System.out.println("Min "+minValue);
		// Old way
		
		
		//Using Stream
		
		System.out.println(IntStream.of(nums).min().getAsInt() );
		
		
		IntStream.of(nums).min().ifPresent( min -> System.out.println(min) );
		
		IntStream.of(nums).min().ifPresent( System.out ::println);

		
		System.out.println(IntStream.of(nums).average().getAsDouble() );
		
		System.out.println(IntStream.of(nums).max().getAsInt() );
		
		System.out.println(IntStream.of(nums).count() );
		
		System.out.println(IntStream.of(nums).sum());
		
		
		IntSummaryStatistics stats = IntStream.of(nums).summaryStatistics();
		
		System.out.println(stats.getAverage());
		System.out.println(stats.getSum());
		System.out.println(stats.getMin());
		System.out.println(stats.getMax());
		System.out.println(stats.getCount());
		
		
		Random1 ran = (i) -> (new Random().nextInt(i));
		
		System.out.println(ran.getRandom(1000) );
	}
	
}

@FunctionalInterface
interface Random1{
	
	public int getRandom(int i);
}

