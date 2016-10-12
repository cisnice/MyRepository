package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Coordinate4 {

	public static void main(String[] args) {
		ArrayList<Integer> numberList = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String input = br.readLine();
			String[] numStrList = input.split(" ");
			for(String numStr : numStrList) {
				numberList.add(Integer.parseInt(numStr));
			}
		} catch (IOException e) {
			e.printStackTrace();			
		}

//		for (Integer number : numberList) {
//		
//		}
		
		String[] strArr = new String[10];
		String[][] intArr = new String[10][2];
		
		for (int i = 0; i < numberList.size(); i++) {
			strArr[i] = String.valueOf(numberList.get(i));
			
			for (int j = 0; j < strArr[i].length(); j++) {
				if ( j == strArr.length-1 ) { 
					intArr[i][j] = strArr[i].substring(j);				
				} else {
					intArr[i][j] = strArr[i].substring(j, j+1);
				}
//				System.out.println("intArr[" + i + "]" + "[" + j + "]" + ":" + intArr[i][j]);
//				if ( intArr[i][j] > intArr[i+1][j] ) {
//					
//				}
			}	
		}		
	}
}
