package ch07.exam06.pack2;

import ch07.exam06.pack1.A;

public class D extends A {
	
	//Field
//	A a = new A();		//상속과 별개로 객체 생성하는 것이므로 에러
	
	//Constructor
	D() {
//		A a = new A();
		
		super();				// 기본 생성자 자동 호출.
		field = 5;			// A클래스 에서 상속받은 필드와 메소드
		method();
		
	}
	
	//Method
	void method2() {	
//		A a = new A();
	}
	
}
