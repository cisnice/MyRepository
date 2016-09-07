package ch12.exam10;

public class PrintThread3 extends Thread {

	@Override
	public void run() {

		while ( true ) {
	
			System.out.println("실행 중......");
//			if( isInterrupted() ) {						//interrupt 상태인지 확인. true 면 interrupt 가 호출된것. 인스턴스 메소드
			if( Thread.interrupted() ) {				// 정적메소드.
				break;
			}
		}		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}	
}
