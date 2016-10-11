package hw;

import java.util.Scanner;

public class StarTest4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();		
		
		for(int i=0; i<num; i++) {  // 0 ~ 4
			for(int j=i; j<num-1; j++) {  // 0 ~ 3
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
//		for(int i=1; i<=num; i++){			
//			for(int j=1; j<=num-i; j++){
//				System.out.print(" ");
//			}
//			for(int j=1; j<=i; j++){
//				System.out.print("*");
//			}			
//			System.out.println();
//		}		
	}
}
