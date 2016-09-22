package ch18.exam15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// 복원
		FileInputStream fis = new FileInputStream("src/ch18/exam15/data.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Member member2 = (Member) ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println(member2.getMid());
		System.out.println(member2.getMname());
		System.out.println(member2.getMpassword());
		System.out.println(member2.getMage());
//		System.out.println(member2.getNation());
		System.out.println(Member.getNation());
		
		
	}
}
