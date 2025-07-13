package regular;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serialization {
    public static void main1(String[] args) {
		A a = new A();
    	a.i=20;
    	try {
			FileOutputStream fous = new FileOutputStream("C:\\share\\file1.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fous);
			oos.writeObject(a);
			oos.close();
			fous.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public static void main2(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:\\share\\file1.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			A a = (A)ois.readObject();
			System.out.println(a.i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void main(String[] args) {
    	Student std  =new Student("Naga", "1949");
    	std.add = new Address("banj", "banjara");
    	try {
			FileOutputStream fous = new FileOutputStream("C:\\share\\file2.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fous);
			oos.writeObject(std);
			oos.close();
			fous.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    
}
