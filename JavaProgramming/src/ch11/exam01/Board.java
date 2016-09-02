package ch11.exam01;

public class Board {
	
	//Field
	private int bno;
	private String title;
	private String content;
	
	//Constructor
	public Board(int bno, String title, String content) {
//		super();				//Object 가 최상위 클래스. 컴파일 할때 자동으로 생성됨
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	@Override
	public boolean equals(Object obj) {		 
		if (obj instanceof Board) {
			Board target = (Board) obj;
			if ( bno == target.bno) {
				return true;
			}
		}		
		return false;
	}	
	
}
