package ch08.exam03;

public class Example {	
	public static void main(String[] args) {		
	
//		RemoteControl.setMute(true);		//객체가 없어서 사용할 수 없다.		
		
		RemoteControl rc = new Television();
		rc.setMute(true);
		rc.setVolume(200);				
		
		RemoteControl.changeBattery();
		
	}
}
