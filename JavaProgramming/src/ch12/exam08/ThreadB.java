package ch12.exam08;

public class ThreadB extends Thread {
	
	private WorkObject workObject;
	
	public ThreadB (WorkObject workObject) {						//Constructor injection
		this.workObject = workObject;
	}
	
//	public void setWorkObject(WorkObject workObject) {		//Setter injection
//		this.workObject = workObject;
//	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}
}
