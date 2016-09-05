package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class ByteToStringExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);

		//-------------------------------------------------------
		
		String str3 = "홍길동";
		byte[] strBytes3 = str3.getBytes();						//2byte UNICODE
		
		String str4 = new String(strBytes3);
		System.out.println(str4);
		
		String str5 = "ab홍길동";
		byte[] strBytes5 = str5.getBytes("UTF-8"); 			//UTF-8 은 한글 한 글자에 3byte. ASCII + UNICODE(각 언어별로 바이트 수가 다름) 
		String str6 = new String(strBytes5, "UTF-8");
		System.out.println(str6);
		
		String str7 = "ab홍길동";
		byte[] strBytes7 = str7.getBytes("EUC-KR"); 		//EUC-KR = ASCII + UNICODE(한글만) 
		String str8 = new String(strBytes7, "UTF-8");
		System.out.println(str8);
		
		String str9 = new String(strBytes7, 2, 6, "EUC-KR");
		System.out.println(str9);
		
		String str10 = new String(strBytes5, 2, 9, "UTF-8");
		System.out.println(str10);
	}

}
