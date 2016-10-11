package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Coordinate22 {

	public static void main(String[] args) {
		String[] words = null;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine();
			words = line.split(" ");			
		} catch (IOException e) {
			e.printStackTrace();			
		}
				
//		String[] strArr = {"a", "e", "i", "o", "u"};
		for (String word : words) {
			int cnt=0;
			if ( word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u") ) {
				System.out.println(word.indexOf(word, 0));				
			}
//			System.out.println(word + " : " +cnt);
		}
		
		ArrayList<String> list = new ArrayList<>();
	}
}
