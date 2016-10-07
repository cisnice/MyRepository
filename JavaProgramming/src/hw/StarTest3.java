package hw;

import java.util.Scanner;

public class StarTest3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int value = (num/2)+1;
		
		for(int i=1; i<=num; i++){
			if(i<=value){
				for(int j=1; j<=i; j++){
					System.out.print("*");				
				}
			}else{
				for(int k=(num-i)+1; k>=1 ; k-- ) {
					System.out.print("*");
				}
			}
			System.out.println();	
		}				
	}
}
