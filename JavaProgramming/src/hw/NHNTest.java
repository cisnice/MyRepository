package hw;

import java.util.Scanner;

public class NHNTest {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);	
//		System.out.println("입력 : ");
		int num = scan.nextInt();
		int i = 2;
		while(i <= 9){
			if (num == i){
				for(int j=1; j<10; j++){
					System.out.println(i + " x " + j + " = " + i*j);
				}				
			}
			i++;
		}
		
		/*if(num > 1 && num < 10){
			for(int i=1; i<10; i++){
				System.out.println(num + " x " + i + " = " + num*i);
			}
		} else {
			System.out.println("범위를 벗어났습니다.");
		}*/
		
	/*for(int i=2; i<10; i++) {		
		if (num == i){
			for(int j=1; j<10; j++) {
				System.out.println(i + " x " + j + " = " + i*j);
			}
		}
	}*/		
	
	}	
}
