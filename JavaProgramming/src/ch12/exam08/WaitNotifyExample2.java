package ch12.exam08;

public class WaitNotifyExample2 {

	public static void main(String[] args) {
		DataBox dataBox = new DataBox();		// 공유 객체
		
		ProducerThread producerThread = new ProducerThread(dataBox);
		ConsumerThread consumerThread = new ConsumerThread(dataBox);
		
		producerThread.start();
		consumerThread.start();		
	}
}
