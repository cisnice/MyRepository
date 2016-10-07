package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Coordinate {

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

        // 다음과 같은 방식으로 numberList와 number 변수를 사용할 수 있음
        /*
        for (Integer number : numberList) {            }
        */

        /*여러 개의 자연수를 표준 입력(standard input)에서 읽어서, 평균 값을 계산하여 출력하세요.

        숫자는 공백으로만 구분됩니다.
        입력은 10개 이하입니다.
        올바른 출력은 하나의 문장이어야 하며, 문장의 마지막은 불필요한 공백문자 없이 newline(개행)으로 끝나야 합니다.
        출력의 포맷은 반드시 소수점 이하 한 자리만 포함해야 합니다.
        예시 설명
        3 9 12가 입력인 경우, 평균 값은 8이다. 따라서 결과는 다음과 같다.
        8.0*/
        
        
        // write your code here
        int sum = 0;
        double avg = 0.0;
        int count = 0;
        for (Integer number : numberList) {            
        	sum += number;
        	count++; 
        }
        avg = (double) sum / count;
                
        DecimalFormat df = new DecimalFormat("#.0");
        String result = df.format(avg);
        
        System.out.println(result);        
	}
}
