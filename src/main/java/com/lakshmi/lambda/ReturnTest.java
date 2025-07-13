package com.lakshmi.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturnTest {

	public static void main(String[] args) {
		
		test();
	}
	
	static void test() {
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		List<Future<Integer>> intList = new ArrayList<>(); 
		Future<Integer> data;
		
		for(int i = 0; i<2; i++) {
			data = pool.submit(
					() -> {
						int j = 1;
						//try { Thread.sleep(2000); } catch (Exception e) { }
						System.out.println("Testing");
						
						Thread.sleep(2000); 
						return j++;
					}
			);
			
			/*data = pool.submit( () -> { 
					Thread.sleep(2000); 
					return 2; 
				});*/
			
			intList.add(data);
		}
		
		for(Future<Integer> future : intList ) {
			
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		
		pool.shutdown();
		
		///////////////////////////////
		
		/*final List<Integer> integers =  Arrays.asList(1,2,3,4,5);
		
		ExecutorService service =  Executors.newSingleThreadExecutor();
		
		Callable<Integer> callableObj = () -> {
			int result = integers.stream().mapToInt(i -> i.intValue()).sum();
			return result;
		};
		
		Future<Integer> future = service.submit(callableObj);
		
		Integer result=0;
		try {
			
			result = future.get();
			System.out.println(result);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		service.shutdown();*/
	
	}
}
