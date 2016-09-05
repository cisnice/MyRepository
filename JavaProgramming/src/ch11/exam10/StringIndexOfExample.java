package ch11.exam10;

public class StringIndexOfExample {

	public static void main(String[] args) {

		String subject = "자바 프로그래밍";
		
		boolean result1 = subject.contains("자바");
		if (result1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}
		
		int result2 = subject.indexOf("자바");
		if (result2 != -1) {										// subject 문자열에 result2 값이 없으면 "-1" 리턴
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}
		
		String token1 = subject.substring(0, 2);	//시작위치, 단어 수
		System.out.println(token1);
		
		int startIndex = subject.indexOf("자바");
		int endIndex = startIndex+2;
		String token2 = subject.substring(startIndex, endIndex);	//시작위치, 단어 수
		System.out.println(token2);
		
		String find = "프로그래밍";
		startIndex = subject.indexOf(find);
		endIndex = startIndex + find.length();
		String token3 = subject.substring(startIndex, endIndex);
		System.out.println(token3);
		
		String token4 = subject.substring(startIndex);
		System.out.println(token4);
	}

}
