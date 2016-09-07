package ch12.exam08;

public class WorkObject {

	public synchronized void methodA() {										//threadA가 methodA를 실행 중이면 threadB는 methodA,B 전부 실행 못한다.
		System.out.println("ThreadA의 methodA() 작업 실행");				//WorkObject 객체 자체가 lock 이걸린다.
		notify();																				//다른 스레드 호출
		try { wait();	} catch (InterruptedException e) {}							//자기 자신 wait
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB의 methodB() 작업 실행");
		notify();
		try { wait();	} catch (InterruptedException e) {}
	}
	
}
