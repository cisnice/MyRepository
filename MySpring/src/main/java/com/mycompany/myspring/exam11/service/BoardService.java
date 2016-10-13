package com.mycompany.myspring.exam11.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myspring.exam11.dao.BoardDao;
import com.mycompany.myspring.exam11.dto.Board;

@Component
public class BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	public void write(Board board) {
		logger.info("write 실행");
		boardDao.insert(board);
	}
	
	public List<Board> getList() {
		logger.info("getList 실행");
		List<Board> list = boardDao.selectList();
		return list;
	}

	public Board getBoard(int bno) {
		logger.info("getBoard 실행");
		Board board = boardDao.selectBoard(bno);
		return board;
	}

	public void updateBoard(Board board) {
		logger.info("updateBoard 실행");
		boardDao.update(board);
	}

	public void deleteBoard(int bno) {
		logger.info("deleteBoard 실행");
		boardDao.delete(bno);
	}	
}
