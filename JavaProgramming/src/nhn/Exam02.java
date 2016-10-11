package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exam02 {
	public static void main(String[] args) {
	
		String[] words = null;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }        
        
        ArrayList<String> al = new ArrayList<>();
        
        for (String word : words) {        
        	al.add(word);       	
        }
        
        
        
	}
}
