package hw;

import java.util.Scanner;

public class StarTest5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		 int i,j,l;
		 
		 for(i=1; i<=num; i=i+2) {        		// 1 ~ 5    
            for (j=num; j>=i; j=j-2) {				// 5 ~ 1
               System.out.print(" ");
            }
            for(l=1; l<=i; l++) {
               System.out.print("*");
            }
            System.out.println();
         }
		 
         for(i=1; i<=num-2; i=i+2) {            
            for (j=1; j<=i; j=j+2) {
                System.out.print(" ");
            }
            System.out.print(" ");
            for(l=num-2; l>=i; l--) {
                System.out.print("*");
            }
            System.out.println();
         }
		
		
		
		
//		int value = num/2;		
//		
//		for(int i=0; i<num; i++) {
//			if(i<=value){
//				for(int j=i; j<num-1; j++) {
//					System.out.print(" ");
//				}
//				for(int k=0; k<=(i*2); k++) {
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}	
		
		
//		String[][] stars = new String[num][num];
//		
//		int value = (num/2);
//		int start = value;
//		int end = start;
//		int k=1;
//		
//		for (int i=0; i<num; i++) {			
//			for (int j=start; j<end; j++) {
//				stars[i][j]=String.valueOf(k);
//				System.out.print(stars[i][j]);
//			}
//			if (i>=value) {
//				start++;
//				end--;
//			} else {
//				start--;
//				end++;
//			}
//			k++;
//			System.out.println();
//		}
	}
}
