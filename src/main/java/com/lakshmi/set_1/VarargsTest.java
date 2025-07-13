package com.lakshmi.set_1;

public class VarargsTest {

	public static void main(String[] args) {
		new VarargsTest().VarargsTest(1, "hello");
		new VarargsTest().VarargsTest(2, "hello", "hi");
	}
	
	public void VarargsTest(int x, String... y) {
		System.out.print(y[y.length-x]+ " ");
	}
	
	/*public void VarargsTest1(String... y, int x) {
		System.out.print(y[y.length-x]+ " ");
	}*/
	
	
	// output is hello hello
	// Method name can be same as class name, although its not a good practice.
	// If vararg parameter is present, it should be the last parameter in a method. So, the syntax is correct.
	// vararg is internally represented as an array, so we can access elements inside it using array notation.
	// Correct answer is “hello hello”
}
