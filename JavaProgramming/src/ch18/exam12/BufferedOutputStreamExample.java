package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
	public static void main(String[] args) throws IOException {
		long start = 0;
		long end = 0;
		
		FileInputStream fis = new FileInputStream("src/ch18/exam12/Koala.jpg");
		FileOutputStream fos = new FileOutputStream("src/ch18/exam12/Koala2.jpg");
	
		int value;		
		start = System.currentTimeMillis();		
		while ( (value = fis.read()) != -1 ) {
			fos.write(value);
		}
		fos.flush();
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		fos.close();
		fis.close();
		
//---------------------------------------------------------------------------------------
		
		FileInputStream fis2 = new FileInputStream("src/ch18/exam12/Koala.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		FileOutputStream fos2 = new FileOutputStream("src/ch18/exam12/Koala2.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
	
		int value2;		
		start = System.currentTimeMillis();		
		while ( (value2 = bis.read()) != -1 ) {
			bos.write(value2);
		}
		bos.flush();
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		bos.close();
		bis.close();
		fis2.close();
		fos2.close();
		
	}	
}
