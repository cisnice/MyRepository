package ch18.exam08;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		
		Scanner scanner1 = new Scanner( System.in );			// InputStream 의 자식객체들이 매개변수로 올수 있다.
		
		System.out.print("나이 : ");										// nextInt, nextDouble는 엔터 전까지 읽는다. 
		int age = scanner1.nextInt();
		
		System.out.print("이름 : ");
		String name = scanner1.nextLine();							// 입력 대기상태에 있다가 엔터 치면 진행. nextInt 뒤에 엔터를 문자로 인식하고 넘어가버림
		
//		System.out.print("나이 : ");
//		int age = scanner1.nextInt();
		
		System.out.print("키 : ");
		double height = scanner1.nextDouble();
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	}
}
