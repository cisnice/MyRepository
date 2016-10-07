package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterSequence {

	public static void main(String[] args) {
		String[] words = null;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 다음과 같은 방식으로 words와 word 변수를 사용할 수 있음
        /*
        for (String word : words) {
            
        }
       
        */

       /* 여러 개의 단어를 표준 입력(standard input)에서 읽어서 각 단어의 길이를 구하고, 그 길이의 합을 출력하세요.

        주어지는 단어의 입력은 10개 이하이며, 20자 이하의 임의의 알파벳 소문자로 구성된 문자열입니다.
        단어는 공백으로만 구분됩니다.
        올바른 출력은 하나의 문장이어야 하며, 문장의 마지막은 불필요한 공백 문자 없이 newline으로 끝나야 합니다.
        예시 설명 
        toast crew payco가 입력인 경우, 각 단어의 길이는 5, 4, 5이며 그 합은 14이다. 따라서 결과는 다음과 같다.
        14 */
        
        // write your code here        
        int sum = 0;
        try {
        	for (String word : words) {
        		sum += word.length();        		
        	}
        } catch (NumberFormatException e) {
        	 e.printStackTrace();
        }
        System.out.println(sum);
	}
}
