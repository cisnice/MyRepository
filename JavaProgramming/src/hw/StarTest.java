package hw;

import java.util.Scanner;

public class StarTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		for (int i=0; i<num; i++) {
			for(int j=0; j<=i; j++ ){
				System.out.print("*");
			}
			System.out.println();
		}	
		
//		for (int i = 1; i <= num; i++) {
//			for(int j = 1; j <= i; j++ ){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
	}
}
