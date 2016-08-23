package ch06.exam03;

public class Car {
	//Field
	String company = "현대자동차";		//제조회사
	
	//Constructor
	Car(){
		System.out.println("Car() 실행됨");
//		Integer.parseInt("a");					// 컴파일 에러
	}
	
	//Method
	void run(){
		System.out.println("run() 실행됨");
	}
	
}


// 201p ~ 202p 6.6 실습