package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coordinate2 {

	public static void main(String[] args) {
		String[] words = null;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine();
			words = line.split(" ");			
		} catch (IOException e) {
			e.printStackTrace();			
		}

		int moCnt = 0;
		int jaCnt = 0;
		for (String word : words) {			
			for (int i=0; i<word.length(); i++) {				
				if ( word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u' ) {
					if ( i != word.length()-1 ) {
						if ( word.charAt(i+1)=='a' || word.charAt(i+1)=='e' || word.charAt(i+1)=='i' || word.charAt(i+1)=='o' || word.charAt(i+1)=='u' ) {
							moCnt++;
						}
					}
				} else if ( word.charAt(i)!='a' && word.charAt(i)!='e' && word.charAt(i)!='i' && word.charAt(i)!='o' && word.charAt(i)!='u' ) {
					if ( i != word.length()-1 ) {
						if ( word.charAt(i+1)!='a' && word.charAt(i+1)!='e' && word.charAt(i+1)!='i' && word.charAt(i+1)!='o' && word.charAt(i+1)!='u' ) {
							if ( i+1 != word.length()-1 ) {
								if ( word.charAt(i+2)!='a' && word.charAt(i+2)!='e' && word.charAt(i+2)!='i' && word.charAt(i+2)!='o' && word.charAt(i+2)!='u' ) {
									jaCnt++;
								}
							}
						}						
					}
				}
			}
		}
		System.out.println(moCnt);
		System.out.println(jaCnt);
	}
}
