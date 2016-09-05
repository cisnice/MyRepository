package ch11.exam10;

public class StringEqualsExample {

	public static void main(String[] args) {
		
		String strVar1 = "홍길동";
		String strVar2 = "홍길동";
		String strVar3 = new String("홍길동");
		
		System.out.println(strVar1 == strVar2);			// 같은 객체인지 번지 비교
		System.out.println(strVar1.equals(strVar2));		// 문자열 비교
		
		System.out.println(strVar1 == strVar3);			// 같은 객체인지 번지 비교
		System.out.println(strVar1.equals(strVar3));		// 문자열 비교
	}

}
