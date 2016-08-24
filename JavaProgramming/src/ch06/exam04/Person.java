package ch06.exam04;

public class Person {

	//Field
	String name;		//객체가 생성될때마다 달라지는 값들은 초기화하지 않는다.
	String sex;
	int age;
	double height;
	boolean married;
	
	
	//Constructor
	Person(String name, String sex, int age, double height){
		this.name = name;	//this는 내가 가지고있는 필드 변수
		this.sex = sex;
		this.age = age;
		this.height = height;
//		this.married = married;
	}
	
	//Method
	
	
}
