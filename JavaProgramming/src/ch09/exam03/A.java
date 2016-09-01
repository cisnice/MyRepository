package ch09.exam03;

public class A {
	//Field
	
	//Constructor
	
	//Method
	public void method(){		//로컬 클래스
		class B {					// public 을 붙일 수 없다. method 안에 선언된 로컬 클래스. method 안에서만 사용할 수 있다.
			//Field
			
			//Constructor
			
			//Method
		}	
		
		B b = new B();
		
	}
	
	
	
}
