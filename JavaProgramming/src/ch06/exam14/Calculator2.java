package ch06.exam14;

public class Calculator2 {
	//Field
	int field1;					//인스턴스 필드. 0으로 초기화 됨. 언제든지 값을 바꿀 수 있다.
	final int field2;			//final - 저장된 값을 바꿀 수 없다. 
	
	static int field3;			//정적
	static final int FIELD4 ;	//static final 은 대문자로 하는 것이 관례
	
	//Constructor
	public Calculator2() {
		field2 = 5;				//생성자에서 초기화
	}
	
	static {
		FIELD4 = 5;				//static block 에서 초기화
	}
	
	//Method
}
