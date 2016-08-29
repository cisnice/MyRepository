package ch06.exam13;

public class SchoolExample {

	public static void main(String[] args) {
		/*
		School s1 = new School();
		School s2 = new School();		//생성자 School 이 private 이기때문에 에러
		 */
		
//		School s1 = School.singleton;		//School 클래스의 필드
//		School s2 = School.singleton;		
//		System.out.println(s1 == s2);
//		
//		School.singleton = null;
//		School s3 = School.singleton;		//null. School 객체가 없어진다. 
		
		School s1 = School.getInstance();		
		School s2 = School.getInstance();		
		System.out.println(s1 == s2);		
		
		//School.singleton = null;					//싱글톤 필드를 private으로 정의. 외부에서 접근을 막아 null 값이 들어가지 않게 막는다.	
		School s3 = School.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
	}

}
