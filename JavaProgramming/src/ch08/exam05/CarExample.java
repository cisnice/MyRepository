package ch08.exam05;

import ch08.exam04.*;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();
		
		myCar.tires[0] = new KumhoTire();
		myCar.tires[1] = new KumhoTire();
		
		System.out.println("--------------------------");
		
		myCar.run();			
	}
}
