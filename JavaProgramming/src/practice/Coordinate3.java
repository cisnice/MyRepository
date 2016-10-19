package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coordinate3 {

	public static void main(String[] args) {
		int number = 0;		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine();
			number = Integer.parseInt(line);			
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
		String[] intArr1 = new String[3];
		String[] intArr2 = new String[3];		
		
		int num1 = 0;
		int num2 = 0;
		int cnt = 0;
		boolean bool = true;
		
		while(bool) {
			String str = String.valueOf(number);
			
			for (int i = 0; i < str.length(); i++) {
				intArr1[i] = str.substring(i, i+1);
			}			
			
			if ( str.length()==3 ) {
				if (Integer.parseInt(intArr1[0]) != Integer.parseInt(intArr1[2])) {
					intArr2[2] = intArr1[0];
					intArr2[1] = intArr1[1];
					intArr2[0] = intArr1[2];			
					num1 = Integer.parseInt(intArr1[0])  * 100 + Integer.parseInt(intArr1[1]) * 10 + Integer.parseInt(intArr1[2]);
					num2 = Integer.parseInt(intArr2[0])  * 100 + Integer.parseInt(intArr2[1]) * 10 + Integer.parseInt(intArr2[2]);
					cnt++;
				} else {
					System.out.println(number);	
					bool = false;
				}
			} else if ( str.length()==2 ) {
				if (Integer.parseInt(intArr1[0]) != Integer.parseInt(intArr1[1])) {
					intArr2[1] = intArr1[0];
					intArr2[0] = intArr1[1];			
					num1 = Integer.parseInt(intArr1[0]) * 10 + Integer.parseInt(intArr1[1]);
					num2 = Integer.parseInt(intArr2[0]) * 10 + Integer.parseInt(intArr2[1]);
					cnt++;
				} else {
					System.out.println(number);	
					bool = false;
				}
			} else if ( str.length()==1 ) {
				intArr2[0] = intArr1[0];			
				num1 = Integer.parseInt(intArr1[0]);
				num2 = Integer.parseInt(intArr2[0]);
			}
			number = num1 + num2;
			
			if (cnt==3){
				System.out.println(-1);
				bool = false;
			}				
		}		
	}
}
