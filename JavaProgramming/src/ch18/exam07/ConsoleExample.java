package ch18.exam07;

import java.io.Console;

public class ConsoleExample {

	public static void main(String[] args) {
		
		Console console = System.console();
		
		System.out.print("아이디 : ");
		String id = console.readLine();
		
		System.out.print("패스워드 : ");
		char[] values = console.readPassword();		//입력은 되고있지만 콘솔에 보이지 않음
		String password = new String(values);
		
		System.out.println("입력된 내용");
		System.out.println(id);
		System.out.println(password);
		
	}
}
