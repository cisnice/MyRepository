package ch06.exam12;

public class Example {

	public static void main(String[] args) {
		//Instance Member 사용
		InstanceMember im = new InstanceMember();  //객체를 만들어 위치정보를 im에 저장한다.
//		im.field = "자바";
		System.out.println(im.field);
		im.method();			//객체 내부에서 메소드 호출
		
		
		//Static Member 사용
		System.out.println(StaticMember.field);		//Static Block 호출됨
		StaticMember.method();		//클래스에서 메소드 호출		

	}

}
