package ch13.exam02;

import java.util.Date;

public class BoxExample {

	public static void main(String[] args) {
//		Box<String> box1 = new Box<String>();		// 타입을 지정하지 않으면 컴파일러는 Object 로 인식한다.
		Box<String> box1 = new Box<>();			// 객체의 타입을 지정하지 않아도 앞의 타입을 적용한다.
		box1.setItem("홍길동");
		String name = box1.getItem();
		
		
		Box<Integer> box2 = new Box<Integer>();
		box2.setItem(10);						
		int value = box2.getItem();
		
		Box<Date> box3 = new Box<Date>();					
		box3.setItem(new Date());
		Date now = box3.getItem();
		
	}
}
