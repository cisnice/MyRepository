package ch07.exam13;

public abstract class Phone {		//스마트폰과 홈폰의 공통점들을 묶어 놓음. 객체X. 상속O
	public String number;
	
	public abstract void ring();		// 추상메소드, 반드시 자식클래스에서 재정의 해야함 
	
	public void sendVoice() {
		System.out.println("음성을 전송합니다.");
	}
	
	public void receiveVoice() {
		System.out.println("음성을 수신합니다.");
	}	
	
}
