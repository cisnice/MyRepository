package com.mycompany.myapp.exam07;

public class Board {
	private int bno;			//index.jsp 에서 넘어오는 파라미터명과 반드시 같아야 한다. @RequestParam 쓰지 못한다.
	private String title;
	private String content;
	private int hitcount;
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	
	
	
}
