package ch08.exam03;

public class Television implements RemoteControl {		//RemoteControl을 구현한 Television 클래스
	
	private int volume;
	
	@Override 					// RemoteControl에 있는 추상메소드가 잘 구성되었는지 컴파일러가 검사
	public void turnOn() {		//public 생략하면 default 가 되므로 생략하면 안됨
		System.out.println("TV를 켭니다.");		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");		
	}

	public int getVolume() {
		return volume;
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;			
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);		
	}		
}
