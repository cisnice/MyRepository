package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
//			System.out.print(number + " ");			
//		}
	
		String[] strArr = new String[10];
		String[] strArr2 = new String[10];
//		String[][] strArr2 = new String[10][2];
		
//		for (int i = 0; i < numberList.size(); i++) {
//			strArr[i] = String.valueOf(numberList.get(i));
//			for (int j = 0; j < strArr.length; j++) {
//				if (strArr[i].length() == 1){
//					strArr2[i] = strArr[i]*10;
//				}
//			}
//		}
	}
//			for (int j = 0; j < strArr[i].length(); j++) {
//				if ( j == strArr.length-1 ) { 
//					strArr2[i][j] = strArr[i].substring(j);				
//				} else {
//					strArr2[i][j] = strArr[i].substring(j, j+1);
//				}
//				System.out.println("[" + i + "]" + "[" + j + "]" + " : " + strArr2[i][j]);
//			}
//		}
//	}
	
//	public class Temp implements Comparable<Temp> {
//
//		@Override
//		public int compareTo(Temp o) {
//			o.
//			return 0;
//		}
//
//		
//	}
}


