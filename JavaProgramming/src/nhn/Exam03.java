package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam03 {
	public static void main(String[] args) {
	
		int number = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }	
		
		
		
	}
}
