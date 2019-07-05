package hrank;

public class DiagonalDifference {
	
//	Given a square matrix, calculate the absolute difference between the sums of its diagonals. It must return an integer representing the absolute diagonal difference.

	public static void main(String[] args) {
		
//		int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7,8 ,9} };
//		int[][] arr = { {1, 2, 1}, {1, 1, 2}, {2, 1 ,1} };
		
		int[][] arr = { {1, 2, 1, 4}, {1, 1, 2, 2}, {2, 1 ,1, 3}, {1, 1 , 2, 3} };
		
		System.out.println(diagonalDifference(arr));
		
	}
	
	static int diagonalDifference(int[][] arr) {
		
		int leftDiagValue = 0, rightDiagValue = 0;
		int[] record;
		int maxIndex = arr.length;
		
		for(int i=0; i < arr.length; i++) {
			record = arr[i];
			
			if(i == 0) {
				maxIndex = record.length - 1;
			} else {
				maxIndex--;
			}
			
			for(int j=0; j<record.length; j++) {
				
				if(i==j) {
					leftDiagValue += record[j]; 
				} 
				
				if(j == maxIndex) {
					rightDiagValue += record[j];
				}
			}
		}
		
		return Math.abs(leftDiagValue - rightDiagValue);
	}

}
