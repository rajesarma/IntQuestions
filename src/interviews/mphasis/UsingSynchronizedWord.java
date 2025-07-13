package interviews.mphasis;

// Which synchronized is not correct

public class UsingSynchronizedWord {
	/*void go1() {
		synchronized () {
			
		}
	}*/
	
	public synchronized void go2() {
		
	}
	
	void go3() {
		synchronized (Object.class) {
			
		}
	}
	
	void go4() {
		Object o = new Object();
		synchronized (o) {
			
		}
	}
}
