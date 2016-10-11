package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Exam04 {
	public static void main(String[] args) {
	
	       ArrayList<Integer> numberList = new ArrayList<Integer>();

	        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	            String input = br.readLine();
	            String[] numStrList = input.split(" ");
	            for (String numStr : numStrList) {
	                numberList.add(Integer.parseInt(numStr));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        int max, min, sum;
	        
	        for (Integer number : numberList) {
	        	
	        	
	        }
	        	        
	}
}
