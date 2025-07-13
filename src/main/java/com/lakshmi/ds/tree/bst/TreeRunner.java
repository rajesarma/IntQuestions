package com.lakshmi.ds.tree.bst;

public class TreeRunner {

	public static void main(String[] args) {
		
		Person jos = new Person("jos", 31);
		Person dp = new Person("dp", 27);
		Person sreedhar = new Person("sreedhar", 26);
		Person swamy = new Person("swamy", 26);
		Person raj = new Person("raj", 36);
		
		BST bst = new BST();
		bst.insert(jos);
		bst.insert(dp);
		bst.insert(sreedhar);
		bst.insert(swamy);
		bst.insert(raj);
		
		bst.showAll(bst.findNode("jos"));
		
		Person p = bst.getData(bst.findParentNode("raj"));
		
		System.out.println(p);

		
	}

}

/*

{
	public static void main(String[] args)
{
Date d = new Date(2011343412345L);
DateFormat df = new DateFormat();
System.out.println(df.format(d));
}
}

Which methods can access to private attributes of a class?
Only Static methods of the same class
(B) Only instances of the same class
(C) Only methods those defined in the same class
(D) Only classes available in the same package com.lakshmi..



static int 0;




java test lets see what happens
public class test
{
	 public static void main(String args[]) 
	 {
     		 System.out.println(args[0]+" "+args[args.length-1]);
	  }
}



k = l++;
j = ++k;
i = j++;


String instance value



class test {
    public static void main(String args[]) {
        char ch;
    String test2 = "abcd";
        String test = new String("abcd");
    if(test.equals(test2)) {
        if(test == test2)
            ch = test.charAt(0);
            else
                ch = test.charAt(1);	           
        }
        else {
        if(test == test2)
            ch = test.charAt(2);
        else                
            ch = test.charAt(3);
    }
        System.out.println(ch);
    }
}



At what stage in the following method does the object initially referenced by s becomes available for garbage collection. Select the one correct answer. 
void method X()  { 
    String r = new String("abc");
    String s = new String("abc");
    r = r+1; //1
    r = null; //2
    s = s + r; //3
} //4*/


/*

public class test {
	public static void main(String args[]) {
		char c;
		int i;
		c = 'A';		// 1
		i = c;		//2
		c = i + 1;	//3
		c++;		//4
	}
}*/