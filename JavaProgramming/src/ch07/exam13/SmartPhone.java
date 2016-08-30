package ch07.exam13;

public class SmartPhone extends Phone {
	public void internet() {
		System.out.println("인터넷을 이용 합니다.");
	}
	
	@Override
	public void ring() {
		System.out.println("띠리링~");
	}
	
}
