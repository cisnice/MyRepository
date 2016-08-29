package ch06.exam14;

public class Calculator3 {
	//Field
	final int field2;			//final - 저장된 값을 바꿀 수 없다. 
	
	
	//Constructor
	public Calculator3(int field2) {
		this.field2 = field2;					//객체마다 다른 값을 갖게 하기 위해 생성자에서 값을 받는다.
	}
	

	//Method
	
	
	//Main Method
	public static void main(String[] args) {
		Calculator3 ca1 = new Calculator3(5);
		Calculator3 ca2 = new Calculator3(7);
		
		
		
	}
	
	
}
