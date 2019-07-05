package generics;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class Shape {
	abstract void draw();
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("Rectangle shape");
	}
}

class Circle extends Shape {
	void draw() {
		System.out.println("Circle shape");
	}
}



public class GenericTest {

	/*public static void gen(List<? super LinkedList> al) {
		
	}*/
	
	public static <T> void drawShapes(List<? extends Shape> shapes) {
		for (Shape s : shapes) {
			s.draw();
		}
	}
	
	
	public static void main(String[] args) {
		
		/*List<List> al = new ArrayList<>();
		
		al.add(al);
		
		gen(al);*/
		
		List<Rectangle> rectList = new ArrayList<Rectangle>();
		rectList.add(new Rectangle());
		rectList.add(new Rectangle());
		
		
		List<Circle> circList = new ArrayList<Circle>();
		circList.add(new Circle());
		circList.add(new Circle());
		circList.add(new Circle());
		
		
		drawShapes(rectList);
		
		drawShapes(circList);
		
	}
	
	
}
