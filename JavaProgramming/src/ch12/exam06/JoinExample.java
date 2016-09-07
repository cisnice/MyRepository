package ch12.exam06;

public class JoinExample {

	public static void main(String[] args) {
		
		SumThread st = new SumThread();
		st.start();
		
		try { st.join(); } catch (InterruptedException e) {}
		System.out.println("1~100 합 : " + st.getSum()); 	//start 에서 run 메소드의 실행이 끝남의 여부에 따라 결과 값이 달라진다. 0 or 5050
		
	}

}
