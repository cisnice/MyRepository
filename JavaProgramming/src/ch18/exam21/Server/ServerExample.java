package ch18.exam21.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	
	private static ServerSocket serverSocket ;
	private static boolean stop;
	
	public static void main(String[] args) {
		
		System.out.println("서버 시작");		
		try {
			//서버의 어떤 IP라도 접근할 수 있도록 한 것
			serverSocket = new ServerSocket(5001);			
			
			Thread thread = new Thread() {
				@Override
				public void run() {
					waitAndAccept();
				}
			};
			thread.start();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어 입력 : ");
			String command = scanner.nextLine();
			
			if(command.equals("stop")) {
				stop = true;						// 작업 스레드 중지 (클라이언트의 연결 수락을 중지)
				try {
					serverSocket.close();			
				} catch (IOException e) { }
				
				System.out.println("서버 종료");
				System.exit(0);						// 서버 프로세스 종료
			}
		}	
	}
	
	private static void waitAndAccept() {			//main 이 static 이기때문에 객체없이 메소드를 불러오기위해 static으로 정의
		try {
			while (!stop) {
				//클라이언트의 연결을 수락하고 통신용 Socket을 생성				
				Socket socket = serverSocket.accept();
				
				try {
					//클라이언트에서 보낸 데이터 받기 
					InputStream is = socket.getInputStream();
					byte[] receiveValues = new byte[1024]; 
					int byteNum = is.read(receiveValues);
					
					if (byteNum != -1) {
						String data = new String(receiveValues, 0, byteNum, "UTF-8");	// 보낸곳과 같게 문자셋 지정	
						
						//클라이언트로 에코 보내기
						OutputStream os = socket.getOutputStream();
						byte[] sendValues = data.getBytes("UTF-8");							// 강제로 문자셋 지정
						os.write(sendValues);
						os.flush(); 
					} else {
						System.out.println("클라이언트가 정상 종료됨");
					}					
					
					//클라이언트와 연결을 끊음
					socket.close();
				} catch (IOException e) {
					System.out.println("클라이언트 비정상 종료됨");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}	
}
