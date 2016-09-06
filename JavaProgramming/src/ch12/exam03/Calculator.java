package ch12.exam03;

public class Calculator {

	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {		// synchronized 메소드 - 한 스레드가 종료될때까지 다른 스레드가 접근하지 못하게 lock을 건다.
		this.memory = memory;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
						
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
	
	public synchronized void method() {
		
	}
	
	
//	public void setMemory(int memory) {
//		//.......
//		synchronized(this) {												// synchronized 블록 - 한 스레드가 종료될때까지 다른 스레드가 접근하지 못하게 lock을 건다.
//			this.memory = memory;
//			
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//							
//			}
//			System.out.println(Thread.currentThread().getName() + " : " + this.memory);
//		}
//		//........
//	}	
}










