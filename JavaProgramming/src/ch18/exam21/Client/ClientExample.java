package ch18.exam21.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientExample {
	
	private static Socket socket ;
	private static boolean stop;

	public static void main(String[] args) {
		
		//소켓 생성
		socket = new Socket();		
		
		try {
			//연결 요청
			SocketAddress sa = new InetSocketAddress("192.168.0.10", 5001);
			socket.connect(sa);
			System.out.println("[서버와 연결됨]");
			
			Thread thread = new Thread(){
				@Override
				public void run() {
					sendAndReceive();					
				}
			};
			thread.start();
								
		} catch (IOException e) {			
			System.out.println("[서버 연결이 안됨]");
			e.printStackTrace();
		}
	}
	
	private static void sendAndReceive() {
		try {
			while (!stop) {			
				//보낼 데이터를 키보드로부터 읽기
				Scanner scanner = new Scanner(System.in);
				System.out.print("명령어 입력[send or stop] : ");
				String data = scanner.nextLine();
				
				if (data.equals("send")) {
					System.out.print("보낼 데이터 : ");					
					data = scanner.nextLine();
					
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
					
				} else if(data.equals("stop")) {
					clientStop();
				}				
			}			
		} catch(Exception e) {
			System.out.println("[서버 연결이 끊어짐]");
		}	
	}
	
	private static void clientStop() {
		//클라이언트의 정상 종료 시키기
		try {
			stop = true;		// 보내고 받기 중지
			socket.close();		// 클라이언트의 정상 종료
			System.out.println("[클라이언트 종료]");
		} catch (Exception e) { }
	}
}
