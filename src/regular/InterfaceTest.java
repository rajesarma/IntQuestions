package regular;

interface A{
	int i=10;
}
interface A2{
	int i=20;
}
public class InterfaceTest implements A,A2 {

	public void test()
	{
		System.out.println(A2.i);
	}
}
