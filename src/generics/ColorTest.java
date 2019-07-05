package generics;

public class ColorTest{
	
	
	public static void main(String[] args) {
		
		Red red = new Red();
		Green green = new Green();
		Blue blue = new Blue();
		
		Color<Red, Green, Blue> color = new Color<>(red, green, blue);
		
		NewColor newColor = new NewColor();
		newColor.<Red,Green> mix(red, green);
		
		Glass2<OrangeJuice> orJuice = new Glass2<OrangeJuice>();
		
		//Glass2<AppleJuice> appJuice = new Glass2<AppleJuice>();
		
	}
	
	
	
}


class Color<R,G,B>{
	
	Color(){}
	
	Color(Red R, Green g, Blue B)
	{}
	
}


class Red{}
class Green{}
class Blue{}

class NewColor{
	public <R, G> void mix(Red red,Green green) {
		System.out.println("mix Color");
	}
	
}


interface Liquid{
	
}


class Juice{
	
}

class OrangeJuice extends Juice implements Liquid{
	
}

class AppleJuice extends Juice {
	
}



class Glass2 <T extends Juice & Liquid>{
	
	
}

