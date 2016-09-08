package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteServiceExample {

	public static void main(String[] args) {
		
		//ThreadPool 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5); 		//최대 5개 생성
		
		//작업 생성
		Runnable task = new Runnable() {
			@Override
			public void run() {
				for ( int i = 0; i < 10; i++) {
					System.out.println("실행 중..." + i + "\t" + Thread.currentThread().getName());
				}
			}
		};
		
		//작업 큐에 작업 넣기
		executorService.submit(task);
		
		//스레드풀 종류
		executorService.shutdown();		// 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드 풀 종료
			
		
		
	}
}
