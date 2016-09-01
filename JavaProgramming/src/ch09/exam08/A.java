package ch09.exam08;

public class A {
	
	interface B {}				//인스턴스 인터페이스	
	class Bimple implements B {
		
	}
	
	static interface C {}		//정적 인터페이스
	class Cimple implements C {		// 이런 식으로 사용 가능하지만 외부 클래스에서 implements 해서 사용하는 경우가 많다. ex)Cimple2 클래스
		
	}
}
