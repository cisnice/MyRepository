package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam05 {
	
	public static void main(String[] args) {
		
		BoardDao dao = new BoardDao();
			
		Board board = new Board();
		board.setBno(7);
		board.setBtitle("제목8");
		board.setBcontent("내용8");
		board.setBwriter("USER8");
		board.setBhitcount(8);
		board.setBdate(new Date());
		
		dao.update(board);
	}
}
