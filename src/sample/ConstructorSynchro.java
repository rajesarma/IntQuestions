package sample;

class A{
	
	public void showValues(String name) throws InterruptedException {
		
		int k=0;
		for (int i = 0; i < 5; i++) {
			System.out.println("Testing .. : "+ name);
			Thread.sleep(1000);
			k=i;
			System.out.println(" k : "+(k+1));
		}
	}
}

class Test extends Thread
{
	A a;
	String name;
	
	Test(A a, String name)
	{
		//synchronized (this) {	// Its of no use
			this.a = a;
			this.name = name;
		//}
	}
	
	//Thread t = new Thread();
	
	@Override
	public void run() {
		try {
			a.showValues(name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ConstructorSynchro {

	public static void main(String[] args) {
		A a= new A();
		Test t1 = new Test(a,"Sarma");
		Test t2 = new Test(a,"Ramu");
		t1.start();
		t2.start();
		
	}

}
