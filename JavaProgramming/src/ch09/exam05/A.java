package ch09.exam05;

public class A {
	int field = 10;
	static int field2 = 5;
	
	B b = new B();
	static B b1 = new B();

	public A() {
		B b = new B();
	}
	
	void method() {
		B b = new B();
	}
	
	static  void method2() {
		B b = new B();
	}
	
	public static class B {		//A 객체가 없어도 사용 가능한 것들만 들어가야한다
		void method() {	
//			field = 3;				//A 객체가 있어야 사용가능
			field2 = 2;
		}
	}
}
