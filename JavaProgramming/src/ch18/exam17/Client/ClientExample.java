package ch18.exam17.Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientExample {

	public static void main(String[] args) {
		
		//소켓 생성
		Socket socket = new Socket();
				
		//연결 요청		
		try {
			SocketAddress sa = new InetSocketAddress("192.168.0.9", 5001);
			socket.connect(sa);
			System.out.println("[서버와 연결됨]");
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		//서버와 연결을 끊음. 다른 클라이언트는 계속 접속할 수 있다.
		try {
			socket.close();
		} catch (IOException e) { }
	}
}
