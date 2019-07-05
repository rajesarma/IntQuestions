package hrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@FunctionalInterface
interface MathOperation{
    int apply(int a, int b, int c);
}

public class MathSeriesElements1 {

	public static void main(String[] args) {

		//List<Integer[]> elemetsList = new ArrayList<Integer[]>();
		//Integer elements[];
		List<List<Integer>> elemetsList = new ArrayList<>();
		List<Integer> elements = new ArrayList<>();
		
		MathOperation m;
		
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int i=0; i<t; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int n = scan.nextInt();
			
			//elements = new Integer[n];
			elements = new ArrayList<>();
			
			for(int j=0; j<n; j++) {
				//elements[j] = getEval(a, b, j);
				//elements.add(getEval(a, b, j));
				
				m = (int d, int e, int f) -> {
					int result=0;
					for(int x=0; x<=f; x++) {
						result += (Math.pow(2, x) * e);
					}
					
					result += d;
					return result;
				};
				
				elements.add(m.apply(a, b, j));
				
			}
			
			elemetsList.add(elements);
		}
		
		scan.close();
		
		/*for(Integer[] eles : elemetsList) {
			for(int j=0; j<eles.length; j++) {
				System.out.print(eles[j] + " "); 
			}
			System.out.println(" ");
		}*/
		
		for(List<Integer> eles : elemetsList) {
			for(Integer ele : eles) {
				System.out.print(ele + " ");
			}
			System.out.println(" "); 
		}
	}
	
	public static int getEval(int a, int b, int j) {
		
		/*int result = a;
				
		for(int k=0; k<=n; k++) {
			result += (Math.pow(2, k) * b);
		}
		
		return result;*/
		
		MathOperation m = (int d, int e, int f) -> {
			int result=0;
			for(int x=0; x<=f; x++) {
				result += (Math.pow(2, x) * e);
			}
			
			result += d;
			return result;
		};
		
		return m.apply(a, b, j);
		
	}
	
	
	/*elements[j] = (a, b, j) -> {
		
		for(int k=0; k<=j; k++) {
			result += (Math.pow(2, k) * b);
		}
		
		result += a;
		return result;
	};*/
	
	/*public static int[][] readValues(int t, int a, int b, int n) {
		
		int opElements[][] = new int[t][n];
		
		for(int i=0;i<t; i++) {
			for(int j=0; j<n; j++) {
				opElements[i][j] = getEval(a ,b , j); 
			}
		}
		
		return opElements;
	}*/
	
//	Map<Integer, Integer> hMap = new HashMap<>();
		
		/*if(t == i)
			for(int k=0; k<t; k++) {
				for(int j=0; j<n; j++) {
					System.out.print(opElements[i][j] + " ");
				}
			}
		}*/
		
		/*for(int i=0; i<elements.length; i++) {
			
			int b[]=new int[elements.length];
			
			for(int j=0; j<b.length; j++) {
				System.out.print(elements[i][j] + " ");
			}
		}*/
		
		/*for (Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
			
			int rows = entry.getKey();
			int columns = entry.getValue();
			
			System.out.println(rows);
			System.out.println(columns);
			
			for(int i=0; i<rows; i++) {
				for(int j=0; j<columns; j++) {
					System.out.print(elements[i][j] + " ");
				}
			}
		}*/
		
		
		/*for(int i=0;i<t; i++) {
			//System.out.println("elements[i].length : "+elements[i].length);
			int[] row = new int[elements[i].length];
			
			for(int j=0; j<row.length; j++) {
				System.out.print(elements[i][j] + " ");
			}
		}*/
		
		/*storeValues(elements, i);
		
		for(int i=0;i<t; i++) {
			for(int j=0; j<opElements[i].length; j++) {
				System.out.print(opElements[i][j] + " ");
			}
		}*/
		
	
	/*public static void storeValues(int[] elements, int t) {
		
		for(int j=0; j<elements.length; j++) {
			opElements[t][j] = elements[j];
		}
		
	}*/
	
	

	
	
	
}
