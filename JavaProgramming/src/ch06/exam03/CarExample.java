package ch06.exam03;

public class CarExample {

	public static void main(String[] args) {
		
		//Car 변수 선언
		Car myCar = null;	//객체를 참조하고 있지 않다.
		
		//Car 객체 생성하고 위치정보 얻기
		try {
			myCar = new Car();	//생성자 호출
		} catch(Exception e) {
			
		}
		
		//Car 객체가 있는지 조사
		if (myCar != null){
			System.out.println("Car 객체 있음");			
		} else {
			System.out.println("Car 객체 없음");
		}				

		//객체 내부의 필드값을 읽어보자
		System.out.println(myCar.company);
		
		//객체 내부의 필드값 변경
		myCar.company = "KOSA";
		System.out.println(myCar.company); 
		
		//객체 내부의 메소드를 호출
		myCar.run();
		
	}

}
