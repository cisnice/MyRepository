package ch06.exam06;

public class Board {
	//Field
	int no;
	String title;
	String content;
	String writer;
	int hitcount;
		
	//Constructor Overloading 
	//1. 매개변수의 수가 달라야한다. 
	//2. 매개변수의 타입이 달라야한다.
	
	Board(){
		
	}
	
	Board(int no){
		
	}
	
//	Board(int hitcount){		// 에러. 위의 생성자와 매개변수의 수와 타입이 같다.
//		
//	}
	
	Board(int no, String title){
		
	}
	
	Board(String title, int no){		// 위 생성자와 수는 같지만 타입이 달라 가능
		
	}
	
	Board(int no, int hitcount){		// 위 생성자와 수는 같지만 타입이 달라 가능
		
	}
	
	Board(int no, String title, String content){
		
	}
	
	Board(int no, String title, String content, String writer){
		
	}
	
	Board(int no, String title, String content, String writer, int hitcount){
		
	}
	
		
	//Method
	
	
}
