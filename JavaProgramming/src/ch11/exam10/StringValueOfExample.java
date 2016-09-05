package ch11.exam10;

public class StringValueOfExample {

	public static void main(String[] args) {
		
		String str1 = "" + 10;
		String str2 = String.valueOf(10); 	// 숫자 -> 문자
		
		int value = Integer.parseInt(str2);	// 문자 -> 숫자
		
		
	}

}
