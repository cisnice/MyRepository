package ch18.exam09;

import java.io.File;

public class FileExample {
	public static void main(String[] args) {
		
//		File file = new File("C/Temp/aa.txt");
		File dir = new File("C:/Temp/dir1/dir2/dir3");
		
		if ( dir.exists() ) {
			if ( dir.isDirectory() ) {
				System.out.println("디렉토리가 존재함");
			} else {
				System.out.println("디렉토리가 존재하지 않음");
			}			
		} else {
			System.out.println("파일이 존재하지 않음");
		}		
		
		dir.mkdirs();
		dir.delete();
	}
}
