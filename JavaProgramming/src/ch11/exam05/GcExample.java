package ch11.exam05;

public class GcExample {
	public static void main(String[] args) {
		
		Employee emp = new Employee(1);
		
		emp = null;	// Employee 객체는 살아있지만 위치정보를 알수 없게된다. 쓰레기 객체
		
		emp = new Employee(2);
		emp = new Employee(3);
		
		System.gc();	// Garbage Collector. 쓰레기 객체 제거
		
	}
}
