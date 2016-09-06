package ch12.exam02;

public class ThreadPriorityExample {

	public static void main(String[] args) {
		
//		Thread ta = new ThreadA();
//		ta.setPriority(Thread.MIN_PRIORITY);
//		
//		Thread tb = new ThreadB();
//		tb.setPriority(Thread.MAX_PRIORITY);		//동시성으로 실행했을 경우는 max가 먼저 끝나지만, 병렬성이기 때문에 우선순위가 영향을 미치지 못한다.
//		
//		ta.start();
//		tb.start();
		
		
		Thread thread = null;
		for(int i = 1; i <= 100; i++) {
			thread = new ThreadC(i);
			
			if( i != 100 ) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);		//100번만 MAX
			}
			thread.start();
		}		
	}

}
