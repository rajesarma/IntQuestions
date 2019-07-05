package hrank;

public class PrimeNumGeneration {

	public static void main(String[] args) {
		int num = 1;
		int dem = 2;
		boolean isPrime = true;
		
		while(num <= 100 ) {
			dem = 2;
			isPrime = true;
			
			while(num > dem ) {
				if(num % dem == 0) {
					isPrime = false;
					break;
				}
				dem++;
			}
			
			if(isPrime && num > 1) {
				System.out.print(num);
				System.out.print(',');
			}
				
			num++;
		}
	}

}
