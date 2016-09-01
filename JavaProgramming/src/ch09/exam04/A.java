package ch09.exam04;

public class A {
	//Field
	B b = new B();
	//static B b1 = new B();		//static은 A 객체가 없어도 사용 가능해야 하지만 B클래스는 static이 아니다.
	
	//Constructor
	public A(){
		B b = new B();		//A객체가 만들어 지면 생성자 호출. B 객체 만들어지고 생성자 호출  
	}
	
	//Method
	void method() {			
		B b = new B();
	}
	
	static void method2() {
//		B b = new B();			//A 객체가 없어도 실행할 수 있는 것만 와야함
	}
	
	//Nested(Inner) Class
	public class B {		//A 객체가 있어야 사용가능
		//Field
		int field1;
//		static field2;
		
		//Constructor
		
		//Method
		void method1(){}
//		static void method2(){}
	}	
}
