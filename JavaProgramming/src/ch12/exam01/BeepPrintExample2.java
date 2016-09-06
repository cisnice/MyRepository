package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Thread thread = new Thread(new Runnable() {		//Runnable 인터페이스를 구현한 클래스 이용. 멀티 스레드
			@Override
			public void run() {
				for ( int i = 0; i < 5; i++) {
					toolkit.beep();
					System.out.println("소리: " + Thread.currentThread().getName());		// 스레드 명 출력
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		});
		thread.start();		// start 하면 run 메소드 실행.

		for ( int i = 0; i < 5; i++) {		//main스레드
			System.out.println("띵");
			System.out.println("출력 : " + Thread.currentThread().getName());		// 스레드 명 출력
			try { Thread.sleep(500); } catch(Exception e) {}
		}
		
	}

}
