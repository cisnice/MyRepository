package hw;

public class A {
	public static int count =0;
	{
		count++;		
	}
	
	public A() {
		count++;		
	}	
	
	public int print() {
		return count;
	}
	
	public static void main(String[] args) {
		A a1 = new A();			
		A a2 = new A();
		System.out.println(a1.print());
	}
}
