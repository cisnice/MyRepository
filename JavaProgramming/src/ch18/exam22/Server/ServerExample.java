package ch18.exam22.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {
	
	private static ServerSocket serverSocket ;
	private static boolean stop;
	private static ExecutorService executorService;
	
	public static void main(String[] args) {
		
		System.out.println("서버 시작");		
		try {
			//스레드풀 생성
			executorService = Executors.newFixedThreadPool(50);			
			
			//서버의 어떤 IP라도 접근할 수 있도록 한 것
			serverSocket = new ServerSocket(5001);			
			
			//클라이언트의 연결을 수락하는 작업 생성
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					waitAndAccept();
				}
			};
			
			//작업을 스레드풀의 작업큐에 넣기
			executorService.submit(runnable);
			
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
					executorService.shutdown();
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
				
				//통신을 담당하는 객체(Client 객체) 생성
				Client client = new Client(socket);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}	
	
	static class Client {
		Socket socket;
		
		public Client(Socket socket) {
			this.socket = socket;
			receive();
		}				
		
		public void receive () {			// 항상 받을 준비 중. 블로킹이 일어날 수 있음. 메인스레드에서 이루어 지면 안됨
			//클라이언트의 데이터를 받고 에코 보내기를 하는 작업 정의
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						while(true){
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
								break;
							}		
						}
					} catch (IOException e) {}		
					
					//클라이언트와 연결을 끊음
					try {
						socket.close();
					} catch (IOException e) {}			
				}
			};
			
			//작업을 스레드풀의 작업큐에 넣기
			executorService.submit(runnable);			
		}		
	}
}
