package ch06.exam07;

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
		//int a = 10;    // 에러. 생성자 호출은 첫줄에 있어야한다.
		this(no, null, null, null, 0);	//객체 자신의 생성자를 호출
		int b = 10;
	}
	
//	Board(int hitcount){		// 에러. 위의 생성자와 매개변수의 수와 타입이 같다.
//		
//	}
	
	Board(int no, String title){
		this(no, title, null, null, 0);
	}
	
	Board(String title, int no){		// 위 생성자와 수는 같지만 타입이 달라 가능
		this(no, title, null, null, 0);
	}
	
	Board(int no, int hitcount){		// 위 생성자와 수는 같지만 타입이 달라 가능
		this(no, null, null, null, hitcount);
	}
	
	Board(int no, String title, String content){
		this(no, title, content, null, 0);
	}
	
	Board(int no, String title, String content, String writer){
		this(no, title, content, writer, 0);
	}
	
	Board(int no, String title, String content, String writer, int hitcount){
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hitcount = hitcount;
	}
	
		
	//Method
	
	
}
