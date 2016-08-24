package ch06.exam12;

public class StaticMember {
	//Static Field
	static String field;
	
	//Static Block - 필드값 초기화
	static {
		System.out.println("Static Block 실행");		//클래스가 처음 사용될때 호출
		field = "자바";	// 필드값 초기화
	}
	
	
	//Static Method
	static void method(){
		
	}

}
