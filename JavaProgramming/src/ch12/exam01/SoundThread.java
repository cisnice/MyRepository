package ch12.exam01;

import java.awt.Toolkit;

public class SoundThread extends Thread {

	//Field
	
	
	//Constructor
	public SoundThread() {
		setName("SoundThread");
	}
	
	//Method
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for ( int i = 0; i < 5; i++) {
			toolkit.beep();
			System.out.println("소리 : " + Thread.currentThread().getName());		// 스레드 명 출력
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
	
}
