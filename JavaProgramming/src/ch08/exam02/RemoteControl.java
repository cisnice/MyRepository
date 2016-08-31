package ch08.exam02;

public interface RemoteControl {

	//Constant
	int MAX_VOLUME = 10;		//public static final 생략. 상수명은 대문자. 단어와 단어 사이는 (_) 로 연결. 초기화 안하면 에러 
	int MIN_VOLUME = 0;
	
	
	//Abstract Method
	void turnOn();						//public abstract 생략. 반드시 객체가 있어야 사용가능.
	void turnOff();
	void setVolume(int volume);
	
	
	//Default Method
	default void setMute(boolean mute) {		//반드시 default 를 명시해야함. public 생략.  반드시 객체가 있어야 사용가능.
		if (mute) {
			System.out.println("무음 처리합니다.");
		} else { 
			System.out.println("무음 해제합니다.");
		}
	}	
	
	//Static Method
	static void changeBattery() {			//static public 위치 바껴도 됨. public 생략 가능
		System.out.println("건전지를 교환합니다.");		
	}
	
}
