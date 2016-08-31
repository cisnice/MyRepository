package ch08.exam02;

public class Example {
	public static void powerOn(RemoteControl rc){	//tv, audio 객체 있음. 다형성 발생
		rc.turnOn();			
	}
	
	public static void main(String[] args) {
		
		int max = RemoteControl.MAX_VOLUME;		//Constant
		int min = RemoteControl.MIN_VOLUME;
		
//		RemoteControl.turnOn();				//Abstract Method. 객체가 있어야 사용가능
//		RemoteControl.turnOff();		
//		RemoteControl.setVolume( RemoteControl.MAX_VOLUME );
		
//		RemoteControl.setMute(true);		//Default Method. 객체가 있어야 사용가능
		
		RemoteControl.changeBattery();		//Static Method
		
		//-----------------------------------------------------
		
		Television tv = new Television();
		tv.turnOn();		//tv 객체에 직접 접근		
		
		RemoteControl rc = tv;
		rc.turnOn();		// 인터페이스로 tv 객체에 접근
		
		Audio audio = new Audio();
		audio.turnOn();
		
		rc = audio;
		rc.turnOn();
		
		//-----------------------------------------------------
		
		powerOn(new Television());		// RemoteControl rc = new Television();
		powerOn(new Audio());			// RemoteControl rc = new Audio();
		
		
	}

}
