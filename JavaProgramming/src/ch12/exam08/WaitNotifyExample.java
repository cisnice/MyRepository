package ch12.exam08;

public class WaitNotifyExample {

	public static void main(String[] args) {
		WorkObject shareObject = new WorkObject();		// 공유 객체
		
		ThreadA threadA = new ThreadA(shareObject);
		ThreadB threadB = new ThreadB(shareObject);
		
		threadA.start();
		threadB.start();
		
	}
}
