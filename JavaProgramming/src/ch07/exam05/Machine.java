package ch07.exam05;

public class Machine {
	
	//Field

	
	//Constructor

	
	//Method
	public void work() {
		System.out.println("Machine-work() 실행");
	}
	
	public final void powerOn() {				//final 메소드 재정의 할 수 없다.
		System.out.println("전원을 연결합니다.");
	}
	
	public final void powerOff() {				//final 메소드 재정의 할 수 없다.
		System.out.println("전원을 끊습니다.");
	}

}
