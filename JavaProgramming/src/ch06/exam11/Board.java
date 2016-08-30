package ch06.exam11;

public class Board {
	
	//Field
	private int no;
	private String title;
	private String writer;	
	private int count;
	private String content;
		
	//Constructor
//	Board(){};
	Board(int no, String title, String writer, int count, String content){
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.count = count;
		this.content = content;
	}
	
	//Method
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
