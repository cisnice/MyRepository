package ch07.exam01;

public class DmbCellPhone extends CellPhone {
	
	//Field
	int channel;
	
	
	//Constructor						 
	DmbCellPhone(String model, String color, int channel) {
//		super();		// 부모클래스의 생성자를 생성한다. 생략가능. 컴파일러가 자동으로 기본 생성자를 생성해준다.
		super.model = model;		//super는 부모 객체를 가르킨다.
		super.color = color;			//this 를 써도 무방하다. 상속받는 것이기 때문에 내가 가지고 있다고 봐도 된다.
		this.channel = channel;	//인스턴스 메소드나 생성자에서만 this, super 를 사용한다.
	}										// static이 붙은 메소드에는 사용하지 못한다.
	
	
	//Method
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다." );		
	}
	
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");		
	}
	
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}

}
