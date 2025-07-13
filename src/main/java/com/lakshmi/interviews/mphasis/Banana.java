package com.lakshmi.interviews.mphasis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Food implements Serializable {
	int good = 3;
}

class Fruit extends Food {
	int juice = 5;
}

public class Banana extends Fruit {
	int yellow = 4;
	
	void serializableBanana(Banana b) {
		try {
			FileOutputStream fos = new FileOutputStream("file.ser");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(b);
			
			out.close();
			fos.close();
			
			
		} catch (IOException e) {
			System.out.println("IO Execption");
		}
	}
	
	Banana deSerializableBanana() {
		FileInputStream fis;
		Banana b3 = null;
		
		try {
			fis = new FileInputStream("file.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			b3 = (Banana)in.readObject();
			
			in.close();
			fis.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return b3; 
	}
	
	public static void main(String[] args) {
		Banana b  = new Banana();
		Banana b2  = new Banana();
		b.serializableBanana(b);
		b2 = b.deSerializableBanana();
		System.out.println("restore "+b2.yellow+b2.juice+b2.good);
	}

}
