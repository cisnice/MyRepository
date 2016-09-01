package ch09.exam10;

public class Example {

	public static void main(String[] args) {
		Parent p = new Parent() {			//Parent를 이용하여 자식클래스를 만들어 객체로 만든다. 자식클래스의 이름은 없다.
			
		};

		RemoteControl rc = new RemoteControl() {		//인터페이스는 객체로 만들수 없지만 {} 를 붙이면 가능. 인터페이스를 구현한 클래스를 객체로 만든다.
			
		};
		
	}

}
