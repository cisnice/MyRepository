package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Coordinate2 {

	public static void main(String[] args) {
		String[] words = null;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine();
			words = line.split(" ");			
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for (String word : words) {
			list.add(word);
		}
				
		int idx=0;
		String str;		
		int[] idxNum = new int[10];
		int moCnt = 0;
		String[] strArr = {"a", "e", "i", "o", "u"};
		
		for (int i=0; i<list.size(); i++) {
			
			for (int j=0; j<strArr.length; j++) {
//				System.out.println(list.get(i));
				if ( list.get(i).contains(strArr[j]) ) { 
					idxNum[j] = list.get(i).indexOf(strArr[j]);
					
//					if ( idxNum[j] != -1 ) {
						
					str = list.get(i).substring(idxNum[i], idxNum[i]+2);						
					System.out.println(str);					
					
					if ( str.contains(strArr[i]) ) {
//					Coordinate4.java		System.out.println(list.get(i));
						moCnt++;							
					}
//					}
				}
			}			
		}
//		System.out.println(moCnt);
	}
}
