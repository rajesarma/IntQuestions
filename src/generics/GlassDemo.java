package generics;

public class GlassDemo{
	
	public static void main(String[] args) {
		Glass<WaterDemo> glass = new Glass<>();
		
		glass.setLiquid(new WaterDemo());
		
		System.out.println(glass.getLiquid() );
		
	}

}


class Glass<T>
{
	public T liquid;

	public T getLiquid() {
		return liquid;
	}

	public void setLiquid(T liquid) {
		this.liquid = liquid;
	}
	
	
	
}

interface Water
{
	
}

class WaterDemo implements Water
{
	
	
}