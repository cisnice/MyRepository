package ch09.exam04;

public class Example {

	public static void main(String[] args) {
		
//		A.B b = new A.B();  	// B 클래스가 static 이 아니라서 직접 B를 볼 수 없다. A객체가 있어야 B에 접근 가능
		
		A a = new A();
		A.B b = a.new B();
		
		b.field1 = 10;
		b.method1();

	}

}
