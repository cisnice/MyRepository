package ch08.exam07;

public class DriverExample {

	public static void main(String[] args) {
		
//		Vehicle vehicle = new Bus();
//		
//		vehicle.run();
////		vehicle.checkFare();		
//		
//		Bus bus = (Bus) vehicle;
//		bus.checkFare();
		
		Driver driver = new Driver();
		driver.drive(new Taxi());
		driver.drive(new Bus());
		
	}

}
