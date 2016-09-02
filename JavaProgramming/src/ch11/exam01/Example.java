package ch11.exam01;

public class Example {

	public static void main(String[] args) {
		Board b1 = new Board(1, "title", "content");
		Board b2 = new Board(1, "title", "content");

		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));		// 객체의 주소값 비교
		
		//equals 에서 true 를 리턴하려면 Board 클래스에서 equals 를 재정의 해야한다.
				
	}
}
