package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteServiceExample3 {

	public static void main(String[] args) {
		
		//ThreadPool 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5); 		//최대 5개 생성
		
		//작업 생성
		for ( int i = 1; i < 10; i ++ ) {				// 50개의 작업. 50개의 작업을 5개의 스레드가 처리한다.
			int count = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;			// 스레드풀에 있는 스레드의 개수를 가져오기 위해 타입 변환
					System.out.println("스레드의 총 수 : " + threadPoolExecutor.getPoolSize());						// 스레드풀에 있는 스레드의 개수					
					System.out.println("실행 중...(" + count + ") : " + Thread.currentThread().getName());			// 스케쥴링에서 실행 기회를 많이 받은 것이 먼저 작업 됨
					int value = Integer.parseInt("aa");			// NumberFormatException 발생
				}
			};
			
			//작업 큐에 작업 넣기
			executorService.submit(task);			// 에러가 나도 출력이 안되고 스레드 수도 유지된다. submit 내부에서 예외처리
//			executorService.execute(task);		// 작업을 하다가 에러가 나면 해당 스레드는 종료되고 새로운 스레드가 생성된다.
		}
		
		//스레드풀 종류
		executorService.shutdown();		// 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드 풀 종료
			
		
		
	}
}
