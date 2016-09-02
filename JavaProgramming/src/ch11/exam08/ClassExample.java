package ch11.exam08;

public class ClassExample {

	public static void main(String[] args) throws ClassNotFoundException {
		
//		Class classCar = Car.class;	//Car 클래스의 메모리 번지를 classCar에 저장		
//		Class classCar = Class.forName("ch11.exam08.Car");
		
		Car car = new Car();
		Class classCar = car.getClass();
		
		System.out.println(classCar.getName());
		System.out.println(classCar.getSimpleName());
		System.out.println(classCar.getPackage());
		System.out.println(classCar.getPackage().getName());
	}

}
