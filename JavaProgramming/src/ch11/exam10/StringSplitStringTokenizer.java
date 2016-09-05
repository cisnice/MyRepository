package ch11.exam10;

import java.util.StringTokenizer;

public class StringSplitStringTokenizer {

	public static void main(String[] args) {
		
		String data = "홍길동,이수홍,박연수,감자바,최명호";		// (,) 로 분리된 각 이름을 token
		
		String[] dataArray = data.split(",");
		System.out.println(dataArray.length);
		
		for ( String name : dataArray) {
			System.out.println(name);
		}
		
		System.out.println("----------------------------------------------");
		
		StringTokenizer st = new StringTokenizer(data, ",");
		System.out.println(st.countTokens());
		
		while ( st.hasMoreTokens() ) {
			String token = st.nextToken();
			System.out.println(token);
		}

		System.out.println("----------------------------------------------");
		
		data = "홍길동&이수홍,박연수,감자바-최명호";		// 구분자가 다를 경우 StringTokenizer 쓸 수 없다. split 으로 분리
		
		dataArray = data.split("&|,|-");
		System.out.println(dataArray.length);
		
		for ( String name : dataArray) {
			System.out.println(name);
		}
	}

}
