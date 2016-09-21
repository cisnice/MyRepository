package ch18.exam11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {

	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		
//		char data = (char) is.read();		// 1바이트만 읽어 한글은 깨진다.
//		byte[] values = new byte[100];
//		int byteNum = is.read(values);
//		String data = new String(values, 0, byteNum-2);
//		System.out.println(data);
				
		Reader reader = new InputStreamReader(is);
		
		char data = (char) reader.read();			// 문자 하나만 읽는다.
		System.out.println(data);

	}

}
