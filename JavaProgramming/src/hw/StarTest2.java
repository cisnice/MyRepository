package hw;

import java.util.Scanner;

public class StarTest2 {
	public static void main(String[] args) {		
	
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		for(int i =1; i<=num; i++){
			for(int j=1; j<=(num-i)+1; j++){
				System.out.print("*");				
			}		
			System.out.println();	
		}				
	}
}
