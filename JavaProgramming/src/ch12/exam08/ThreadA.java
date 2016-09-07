package ch12.exam08;

public class ThreadA extends Thread {
	
	private WorkObject workObject;
	
	public ThreadA (WorkObject workObject) {						//Constructor injection
		this.workObject = workObject;
	}
	
//	public void setWorkObject(WorkObject workObject) {		//Setter injection
//		this.workObject = workObject;
//	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodA();
		}
	}
}
