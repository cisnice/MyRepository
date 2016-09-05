package ch11.exam10;

import java.io.IOException;

public class KeyboardToStringExample {

	public static void main(String[] args) throws IOException {
		
		byte[] bytes = new byte[100];
		
		System.out.println("입력 : ");
		int readByteNo = System.in.read(bytes);		//read = 읽은 byte 수, 엔터 = 2byte
		
		//String str = new String(bytes);
		String str = new String( bytes, 0, readByteNo-2);		// 엔터 빼기위해 (-2)
		System.out.println(str);		
		
	}
}
