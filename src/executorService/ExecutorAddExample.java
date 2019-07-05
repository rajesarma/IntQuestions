package executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableAdder implements Callable<Integer>{
	
	Integer value1;
	Integer value2;
	
	public CallableAdder(Integer value1, Integer value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	@Override
	public Integer call() throws Exception {
		
		//System.out.println("Value 1 : "+ value1+", Value 2 : "+value2);
		return value1+value2;
	}
	
	
}

public class ExecutorAddExample {

	Integer parallelSum() {
		
		ExecutorService exec = Executors.newFixedThreadPool(10);
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		int totalSum =0;
		int current = 0;
		
		for(int i=1; i<=100; i+=2 )
		{
			current = i;
			System.out.println("current : "+current + ", next : "+ (current + 1) );
			Future<Integer> future = exec.submit(new CallableAdder(current, (current + 1)));
			list.add(future);
		}
		
		for(Future<Integer> future: list){
			try {
				totalSum += future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println("Total Sum : "+totalSum);
		
		return totalSum;
	}
	
	
	public static void main(String[] args) {
		ExecutorAddExample exec = new ExecutorAddExample();
		
		int totalSum = exec.parallelSum();
		
		System.out.println("Total Sum : "+totalSum);
		
	}
	
}
