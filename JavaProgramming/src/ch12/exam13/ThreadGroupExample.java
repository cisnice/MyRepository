package ch12.exam13;

public class ThreadGroupExample {

	public static void main(String[] args) {
		
		Thread thread = Thread.currentThread();		//현재 스레드 객체 
		System.out.println(thread.getName());				//현재 스레드 이름
		
		for ( int i =0; i<10; i++ ) {
			int count = i;											//익명객체 안에서 로컬변수를 사용할 수 없다. final의 특성을 가진다. 임의의 변수에 넣어 사용한다.
			Thread thread2 = new Thread() {
				@Override
				public void run() {
					while ( true ) {
						System.out.println("Thread" + count + " : 실행중...");		
						if ( isInterrupted() ) break;
					}
					System.out.println("Thread" + count + " : 종료");
				}
			};
			thread2.start();
		}
		
		ThreadGroup mainGroup = thread.getThreadGroup();
		System.out.println(mainGroup.getName());	//현재 스레드 그룹 이름		
		System.out.println(mainGroup.activeCount());	// activeCount 는 현재 활동하고 있는 스레드 수.
		
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		
		mainGroup.interrupt();		
	}
}
