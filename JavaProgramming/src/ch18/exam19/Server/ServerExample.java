package ch18.exam19.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		
		System.out.println("서버 시작");
		ServerSocket serverSocket = null;
		try {
			//서버의 어떤 IP라도 접근할 수 있도록 한 것
			serverSocket = new ServerSocket(5001);			
			
			for (int i=0; i<10; i++) {
				//클라이언트의 연결을 수락하고 통신용 Socket을 생성				
				Socket socket = serverSocket.accept();

				//클라이언트에서 보낸 데이터 받기 
				InputStream is = socket.getInputStream();
				byte[] receiveValues = new byte[1024]; 
				int byteNum = is.read(receiveValues);
				String data = new String(receiveValues, 0, byteNum, "UTF-8");	// 보낸곳과 같게 문자셋 지정	
				
				//클라이언트로 에코 보내기
				OutputStream os = socket.getOutputStream();
				byte[] sendValues = data.getBytes("UTF-8");							// 강제로 문자셋 지정
				os.write(sendValues);
				os.flush(); 
				
				//클라이언트와 연결을 끊음
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			serverSocket.close();			// 가동 중인 서버 종료
		} catch (IOException e) { }
		
		System.out.println("서버 종료");
	}
}
