package ch10.exam01;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {			
			try {										// 일단 실행
//				String data = "1o";				// NumberFormatException
				System.out.print("입력 : ");
				String data = scanner.nextLine();
				
				int value = Integer.parseInt(data);
				System.out.println(value);
				
			} catch(Exception e) {	 			// try 에서 에러 발생하면 실행. 예외 처리
				System.out.println("숫자가 아닌 것 같습니다.");
			} finally {								// 무조건 실행
				System.out.println("무조건 실행");
			}
		}
	}

}
