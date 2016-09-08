package ch13.exam05;

public class Util {

	public static <T> Box<T> boxing(T t) { 	//Box<T> 리턴타입, boxing 메소드 이름
		Box<T> box = new Box<T>();
		box.setItem(t);
		return box;
	}
	
}
