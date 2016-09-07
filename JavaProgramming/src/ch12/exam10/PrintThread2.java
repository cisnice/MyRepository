package ch12.exam10;

public class PrintThread2 extends Thread {

	@Override
	public void run() {
		try {
			while ( true ) {
		
			System.out.println("실행 중......");
			Thread.sleep(1);							// 일시 정지 상태가 되는 순간 예외발생
			}
		} catch(InterruptedException e) {}
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
	
}
