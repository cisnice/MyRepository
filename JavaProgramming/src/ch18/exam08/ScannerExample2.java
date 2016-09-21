package ch18.exam08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerExample2 {
	public static void main(String[] args) throws FileNotFoundException {
		
		InputStream is = new FileInputStream("src/ch18/exam08/data.txt");
		Scanner scanner1 = new Scanner( is );			// InputStream 의 자식객체들이 매개변수로 올수 있다.
				
		String name = scanner1.nextLine();
		int age = scanner1.nextInt();
		double height = scanner1.nextDouble();		
//		int age = Integer.parseInt(scanner1.nextLine());
//		double height = Double.parseDouble(scanner1.nextLine());
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	}
}
