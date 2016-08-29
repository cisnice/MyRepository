package ch07.exam06.pack1;

public class A {
		
	//Field
	protected int field; 			// public 과 default 접근 제한의 중간. 패키지가 다르더라도 상속은 된다.
	
	
	//Constructor
	protected A(){}				//상속받은 자식 클래스에서 기본 생성자 생성 가능. super();
	
	
	//Method
	protected void method() {
		
	}
	
}
