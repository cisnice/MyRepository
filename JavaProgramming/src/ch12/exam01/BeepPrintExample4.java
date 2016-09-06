package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample4 {

	public static void main(String[] args) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Thread thread = new SoundThread();
		thread.start();		

		for ( int i = 0; i < 5; i++) {		//main스레드
			System.out.println("띵");		
			System.out.println("출력 : " + Thread.currentThread().getName());		// 스레드 명 출력
			try { Thread.sleep(500); } catch(Exception e) {}
		}			
	}

}
