package ch08.exam05;

import ch08.exam04.*;

public class Car {
	
	Tire[] tires = {
			new HankookTire(),
			new HankookTire(),
			new HankookTire(),
			new HankookTire()
	};
	
	void run() {
		for (Tire tire : tires) {
			tire.roll();
		}
	}
	
	
}
