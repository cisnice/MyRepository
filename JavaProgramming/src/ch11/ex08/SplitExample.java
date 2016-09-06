package ch11.ex08;

import java.util.StringTokenizer;

public class SplitExample {

	public static void main(String[] args) {

		String str = "아이디,이름,패스워드";
		
		//방법1 (split() 메소드 사용) 
		String[] result = str.split(",");
		
		for (String info : result) {
			System.out.println(info);
		}
		
		System.out.println();
		
		//방법2 (StringTokenizer 메소드 사용) 
		StringTokenizer st = new StringTokenizer(str, ",");
		int countTokens = st.countTokens();
		
		for(int i = 0; i < countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
	}

}
