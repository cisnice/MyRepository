package ch07.exam03;

public class Robot extends Machine {
	
	//Field

	
	//Constructor

	
	//Method
//	@Override						//오버라이드 할때 사용하면 컴파일러가 부모클래스에서 해당 메소드를 검사한다.
//	public void work() {			//부모가 public 이면 자식도 public, 부모가 void면 자식은 public, void 다 된다.
//		System.out.println("Robot-work() 실행");
//	
//	}
	
	//ctrl+space 재정의할 메소드 선택
	@Override
	public void work() {
		super.work();   	//부모의 메소드를 무조건 실행해야 할 때 super.method()
		System.out.println("Robot-work() 실행");
	}
	
}
