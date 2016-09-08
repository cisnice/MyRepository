package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteServiceExample2 {

	public static void main(String[] args) {
		
		//ThreadPool 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5); 		//최대 5개 생성
		
		//작업 생성
		for ( int i = 1; i < 1000; i ++ ) {				// 50개의 작업. 50개의 작업을 5개의 스레드가 처리한다.
			int count = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					for ( int i = 0; i < 10; i++) {
						System.out.println("실행 중...(" + count + ") : " + Thread.currentThread().getName());		//스케쥴링에서 실행 기회를 많이 받은 것이 먼저 작업 됨
					}
				}
			};
			
			//작업 큐에 작업 넣기
			executorService.submit(task);
		}
		
		//스레드풀 종류
		executorService.shutdown();		// 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드 풀 종료
			
		
		
	}
}
