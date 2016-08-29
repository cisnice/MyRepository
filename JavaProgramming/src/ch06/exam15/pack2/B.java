package ch06.exam15.pack2;

import ch06.exam15.pack1.A;

public class B {
	//Field
	A a1 = new A();			// 전역변수
	
	
	//Constructor
	public B() {
		A a2 = new A();		// 로컬변수
	}
	
	
	//Method
	void method() {
		A a3 = new A();		// 로컬변수
	}
	
	
	
}
