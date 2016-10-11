package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Coordinate21 {

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
//		String[] strArr = {"a", "e", "i", "o", "u"};
		
		for (int i=0; i<list.size(); i++) {
			if ( list.get(i).contains("a") || list.get(i).contains("e") || list.get(i).contains("i") || list.get(i).contains("o")|| list.get(i).contains("u") ) {
				for (int j=0; j<list.get(i).length(); j++) {
//				System.out.println(list.get(i));
//				if ( list.get(i).contains(strArr[j]) ) { 
					idxNum[j] = list.get(i).indexOf("a");
					
					if ( idxNum[j] != -1 ) {
						str = list.get(i).substring(idxNum[j], idxNum[j]+2);						
						System.out.println(str);					
						
//						if ( str.() ) {
//							System.out.println(list.get(i));
//							moCnt++;							
//						}
					}
				}
			}			
		}
//		System.out.println(moCnt);
	}
}
