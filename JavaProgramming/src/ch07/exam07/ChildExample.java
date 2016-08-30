package ch07.exam07;

public class ChildExample {

	public static void main(String[] args) {
		
		Child child = new Child();
		child.method1();
		child.method2();
		child.method3();
		
		System.out.println("-------------------------");
		
		Parent p = child;
		p.method1();
		p.method2();		//재정의된 child 클래스의 메소드2가 호출된다.

	}

}
