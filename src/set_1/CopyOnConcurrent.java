package set_1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnConcurrent {

	public static void main(String[] args) {
		
		Set<String> set = new CopyOnWriteArraySet<>();
		set.add("Test1");
		set.add("Test2");
		set.add("Test3");
		set.add("Test4");
		
//		System.out.println(set);
		System.out.println("Before");
		
		Runnable t1 = new Runnable() {
			
			@Override
			public void run() {
			
				try {
					
					
					Iterator<String> it =  set.iterator();
							
					while(it.hasNext()) {
						Thread.sleep(2000);
						System.out.println(it.next());
					}
					
					System.out.println("After");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable t2 = new Runnable() {
			
			@Override
			public void run() {
			
				try {
					
					Iterator<String> it =  set.iterator();
							
					while(it.hasNext()) {
						Thread.sleep(2000);
						it.remove();
						System.out.println(it.next());
					}
					
					System.out.println("After");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.run();
		t2.run();
		
	}
	
	
}




