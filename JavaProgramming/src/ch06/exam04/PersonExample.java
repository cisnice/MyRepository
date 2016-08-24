package ch06.exam04;

public class PersonExample {

	public static void main(String[] args) {
		
		Person p1 = new Person("홍길동", "남", 18, 180.5);
		
		System.out.println(p1.name);
		System.out.println(p1.sex);
		System.out.println(p1.age);
		System.out.println(p1.height);
		System.out.println(p1.married);
		
		//데이터수정
		p1.age = 27;
		System.out.println(p1.age);
		
	}

}
