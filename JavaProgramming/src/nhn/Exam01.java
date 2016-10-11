package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Exam01 {
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
	        
//	        for(Integer number : numberList) {
//	        	System.out.println("number : " + number);
//	        }
//	        System.out.println("--------------------------------------");
	        
	        Collections.sort(numberList);
	        
	        int firstNum = numberList.get(0);
	        int secondNum;
	        int diffNum;
	        int min=1000000000;
	        int minFirst=0, minSecond=0;
	        
	        for(int i=1; i<numberList.size(); i++) {
	        	secondNum = numberList.get(i);
	        	diffNum = secondNum-firstNum;
//	        	System.out.println(secondNum + " - " + firstNum + " = " + diffNum);	        	
	        	if(diffNum < min){
		        	min = diffNum;	  
		        	minFirst = firstNum;
		        	minSecond = secondNum;		        			        	
	        	}	        	
	        	firstNum = secondNum;
	        }
	        System.out.println(minFirst + " " + minSecond);
	        
	        
	        
	        
	        
	        
	       /* int first = 0;
	        int second = 0;
	        int[] diff = new int[numberList.size()];
	        int minResult = 0; 
	        int minFirst=0; 
	        int minSecond =0;
	        int count=0;
	        
	        for (int i=0; i<numberList.size(); i++) {
	        	first = numberList.get(i);
	        	for (int j=i+1; j<numberList.size(); j++) {
	        		second = numberList.get(j);   
	        		diff[count] = Math.abs(first-second);	        		
	        		System.out.println(first + " - " + second + " = " + diff[count]);	        			        		        	
	        		
		        	if(diff[i] < diff[count]) {
	        			minResult = diff[i];
	        			minFirst = first;
	        			minSecond = second;
	        		} else if (diff[i] > diff[count]) {
	        			minResult = diff[count];
	        			minFirst = first;
	        			minSecond = second;
	        		} else {
	        			continue;
	        		}        		
		        	count++;
//	        		System.out.println(first + " - " + second + " = " + diff[count] + " , " + minResult+ " , " + minFirst+ " , " + minSecond);
	        	}	
	        	
	        }	*/

	}
}
