package ch08.exam02;

public class Audio implements RemoteControl {		//오디오 클래스는 RemoteControl 인터페이스를 사용 할 수 있다.																		
	
	@Override 					// RemoteControl에 있는 추상메소드가 잘 구성되었는지 컴파일러가 검사
	public void turnOn() {		//public 생략하면 default 가 되므로 생략하면 안됨
		System.out.println("Audio를 켭니다.");		
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");		
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("현재 Audio 볼륨 : " + volume);
		
	}		
	
}
