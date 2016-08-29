package ch06.exam16.pack1;

public class A {
	//Field
	private int field1;			// 해당 클래스 에서만 사용 가능
	int field2;					// 같은 패키지 내에서만 사용 가능.  pack1 내에서만 
	public int field3;			// 모든 곳에서 사용 가능. 패키지가 달라도 사용가능
	
	//Constructor
	private A(){}
	A(int field1){}
	public A(int field2, int field3){}
	
	//Method
	private void method1(){}
	void method2(){}
	public void method3(){}
}
