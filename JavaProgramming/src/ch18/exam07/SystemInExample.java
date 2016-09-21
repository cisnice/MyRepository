package ch18.exam07;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample {

	public static void main(String[] args) throws IOException {
		
		//한개의 키만 읽기
//		int keyCode = System.in.read();
		InputStream is = System.in;
		
//		System.out.println("키 하나만 입력 : ");
//		int keyCode = is.read();
//		System.out.println(keyCode + " : " + (char)keyCode);
		
		//한글과 같은 여러키의 조합을 읽기		
		System.out.println("여러키 입력 : ");
		
		byte[] values = new byte[100];
		int byteNum = is.read(values);
		String data = new String(values, 0 , byteNum-2);
		System.out.println(data);
		
		
	}
}
