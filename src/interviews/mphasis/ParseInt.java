package interviews.mphasis;

public class ParseInt {

	public static void main(String[] args) {
		try {
		int x = Integer.parseInt("two");
		} catch (NumberFormatException e) {
			System.out.println("Number Format");
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal");
		}
	}
}
