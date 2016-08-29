package ch06.exam12;

public class StaticMember2 {
	//Static Field
	static String field;
	String field2;
	
	
	//Static Block - 필드값 초기화
	static {
		System.out.println("Static Block 실행");		//클래스가 처음 사용될때 호출
		field = "자바";	      // 필드값 초기화
//		field2 = "자바";	//에러. 객체가 없어 초기화 안됨
	}	
	
	
	//Static Method
	static void method(){
		field = "자바";
//		field2 = "자바";	//에러. 객체가 없어 초기화 안됨
	}
	
	void method2(){	
		field = "자바";
		field2 = "자바";
	}
	
	public static void main(String[] args) {	//클래스 멤버X. 실행을 위한 main 메소드. 
		field = "자바";
//		field2 = "자바";	//인스턴스 멤버이기 때문에 사용 X
		
		method();
//		method2();			//인스턴스 메소드이기 때문에 사용 X
		
		StaticMember2 sm = new StaticMember2();
		sm.field2 = "자바";
		sm.method2();
		
		
		
		
		
		
		
	}

}
