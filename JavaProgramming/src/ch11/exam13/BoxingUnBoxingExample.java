package ch11.exam13;

public class BoxingUnBoxingExample {

	public static void main(String[] args) {
		
		Integer obj = 100;		//자동 Boxing. 100이라는 Integer 객체를 만들어 주소 값을 obj에 저장한다.
		int value = obj;			//자동 UnBoxing. obj에 있는 100 이라는 값을 int 변수 value 에 저장한다.
		System.out.println(value);
		
		int result = obj +200;
		System.out.println(result);
		
	}

}
