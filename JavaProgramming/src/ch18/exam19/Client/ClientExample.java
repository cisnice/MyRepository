package ch18.exam19.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientExample {

	public static void main(String[] args) {
		
		//소켓 생성
		Socket socket = new Socket();
				
		
		try {
			//연결 요청
			SocketAddress sa = new InetSocketAddress("192.168.0.10", 5001);
			socket.connect(sa);
			System.out.println("[서버와 연결됨]");
			
			//보낼 데이터를 키보드로부터 읽기
			Scanner scanner = new Scanner(System.in);
			System.out.print("보낼 데이터 : ");
			String data = scanner.nextLine();
			
			//서버로 데이터 보내기
			OutputStream os = socket.getOutputStream();
			byte[] sendValues = data.getBytes("UTF-8");					// 강제로 문자셋 지정
			os.write(sendValues);
			os.flush(); 
			
			//서버에서 보낸 데이터 읽기
			InputStream is = socket.getInputStream();
			byte[] receiveValues = new byte[1024]; 
			int byteNum = is.read(receiveValues);
			data = new String(receiveValues, 0, byteNum, "UTF-8");		// 보낸곳과 같게 문자셋 지정
			System.out.println(data);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		//서버와 연결을 끊음. 다른 클라이언트는 계속 접속할 수 있다.
		try {
			socket.close();
		} catch (IOException e) { }
	}
}
