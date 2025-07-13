package interviews.mphasis;

public class MyLogger {
	
	private StringBuilder logger = new StringBuilder();
	
	public void log(String message, String user) {
		logger.append(message);
		logger.append(user);
	}
	
	public static void main(String[] args) {
		// The programmer must guarantee that a single MyLogger object works properly for a multi-threaded
	}

}
