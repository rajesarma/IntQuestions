package questions;

class Game {
	public int number;
}

public class Test1 {

	public void PlayIt(int i, Game p) {
		i =5;
		p.number = 8;
	}
	
	public static void main(String[] args) {
		int x = 0;
		Game p = new Game();
		new Test1().PlayIt(x, p);
		System.out.println(x + " "+ p.number);
	}
	
}
