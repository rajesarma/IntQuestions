package sample;

import java.util.Map;
import java.util.TreeMap;

public class LetterCount {

	public static void main(String[] args) {
		//String name ="SatyaNarayana Rao";
		String name ="madam";
		TreeMap<Character, Integer> lettterMap= new TreeMap<>();
		
		for(int i=0; i< name.length(); i++)
		{
			if(lettterMap.containsKey(name.charAt(i)))
				lettterMap.put(name.charAt(i), (lettterMap.get(name.charAt(i)) + 1));
			else
				lettterMap.put(name.charAt(i), 1);
		}
		
		for(Map.Entry set : lettterMap.entrySet() )
			System.out.println(set.getKey() +" count : "+ set.getValue());
	}
	
}
