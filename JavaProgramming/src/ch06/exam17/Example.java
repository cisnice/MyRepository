package ch06.exam17;

public class Example {

	public static void main(String[] args) {
		Member m1 = new Member("angel");
//		System.out.println(m1.mid);			//private이라 접근하지 못함
		System.out.println(m1.getMid());
		
//		m1.mid = 'white';			// private이라 접근하지 못함. 값 변경을 막는다.
		
		m1.setMheight(-100.0);
	}
}
