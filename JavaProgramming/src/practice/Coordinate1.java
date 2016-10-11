package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Coordinate1 {

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
//			System.out.println("number = " + number);
//		}
		
		Collections.sort(numberList);
		
		int firstNum = numberList.get(0);
		int secondNum = 0;
		int min = 10000000;
		int diff = 0;
		int resultFirst = 0;
		int resultSecond = 0;		
		
		for (int i = 1; i < numberList.size(); i++) {
			secondNum = numberList.get(i);
			diff = secondNum-firstNum;
			if(min > diff) {
				min =  diff;
				resultFirst = firstNum;
				resultSecond = secondNum;				
			}
			firstNum = secondNum;
		}
		System.out.println(resultFirst + " " + resultSecond);
	}
}
