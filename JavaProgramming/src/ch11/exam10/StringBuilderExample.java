package ch11.exam10;

public class StringBuilderExample {

	public static void main(String[] args) {
		
		String data = "a";
		data += "b";
		data += "c";            // jdk1.4 까지는 String 객체 3개 생성됨. jdk1.5 부터는 StringBuilder		
		System.out.println(data);
		
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		System.out.println(sb);
		
		String data2 = "abc";
		StringBuilder sb2 = new StringBuilder(data2);
		sb2.insert(1, "0");
		data2 = sb2.toString();
		System.out.println(data2);
		
	}

}
