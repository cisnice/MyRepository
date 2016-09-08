package ch12.exam04;

public class StatePrintThread extends Thread {	
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	public void run() {
		while(true) {
			Thread.State state = targetThread.getState();		//Thread.State 열거타입
			System.out.println("타겟 스레드 상태: " + state);		
			if(state == Thread.State.NEW) {							//NEW - 스레드 객체생성. start() 메소드가 호출되지 않은 상태
				targetThread.start();
			}
			if(state == Thread.State.TERMINATED) {
				break;
			}
			try {
				//0.5초간 일시 정지
				Thread.sleep(500);
			} catch(Exception e) {}
		}
	}
}
