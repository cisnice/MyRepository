package ch12.exam13;

public class ThreadGroupExample2 {

	public static void main(String[] args) {
		Thread thread;
		
		thread = new Thread("t1") {		
			@Override
			public void run() {
				while ( true ) {
					System.out.println(getName() + " : 실행중...");		
					if ( isInterrupted() ) break;
				}
				System.out.println(getName() + " : 종료");
			}
		};
		thread.start();
		
		thread = new Thread("t2") {		
			@Override
			public void run() {
				while ( true ) {
					System.out.println(getName() + " : 실행중...");		
					if ( isInterrupted() ) break;
				}
				System.out.println(getName() + " : 종료");
			}
		};
		thread.start();
		
		ThreadGroup sub = new ThreadGroup("sub");
		
		thread = new Thread(sub, "t3") {						// 스레드 그룹 생성
			@Override
			public void run() {
				while ( true ) {
					System.out.println(getName() + " : 실행중...");		
					if ( isInterrupted() ) break;
				}
				System.out.println(getName() + " : 종료");
			}
		};
		thread.start();
		
		thread = new Thread(sub, "t4") {						// 스레드 그룹 생성
			@Override
			public void run() {
				while ( true ) {
					System.out.println(getName() + " : 실행중...");		
					if ( isInterrupted() ) break;
				}
				System.out.println(getName() + " : 종료");
			}
		};
		thread.start();
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		
		sub.interrupt();		//sub 그룹만 interrupt
		Thread.currentThread().getThreadGroup().interrupt();		//메인 그룹 interrupt
	}
}
