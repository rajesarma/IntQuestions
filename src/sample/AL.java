package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AL {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		
		al.add(null);
		al.add(null);
		al.add(null);
		al.add(null);
		al.add(null);
		
		/*for(int i=0; i< al.size(); i++)
			System.out.println(al.get(i));
		*/
		Set s = new HashSet();
			s.add(null);
			s.add(null);
			s.add(null);
			s.add(null);
		
		Iterator i = s.iterator();
		
		while(i.hasNext())
			System.out.println(i.next());
				
	}
	
}
