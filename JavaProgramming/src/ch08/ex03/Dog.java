package ch08.ex03;

public class Dog implements Soundable {

	@Override
	public String sound() {
		System.out.println("멍멍");
		return null;
	}

}
