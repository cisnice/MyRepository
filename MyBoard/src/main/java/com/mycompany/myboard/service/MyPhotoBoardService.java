package com.mycompany.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myboard.dao.MyPhotoBoardDao;
import com.mycompany.myboard.dto.MyPhotoBoard;

@Component
public class MyPhotoBoardService {
	
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private MyPhotoBoardDao myphotoBoardDao;
	
	public List<MyPhotoBoard> list(int pageNo, int rowsPerPage) {
		return myphotoBoardDao.selectByPage(pageNo, rowsPerPage);				
	}
	
	public int write(MyPhotoBoard myPhotoBoard) {
		int row = myphotoBoardDao.insert(myPhotoBoard);
		return WRITE_SUCCESS;
	}
	
	public int modify(MyPhotoBoard myPhotoBoard) {
		int row = myphotoBoardDao.update(myPhotoBoard);
		if ( row == 0 ) {
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}

	public int remove(int bno) {
		int row = myphotoBoardDao.delete(bno);
		if ( row ==0 ) {
			return REMOVE_FAIL;
		}
		return REMOVE_SUCCESS;		
	}
	
	public MyPhotoBoard info(int bno) {
		return myphotoBoardDao.selectByBno(bno);
	}
	
	public int getCount() {
		return myphotoBoardDao.count();
	}
}
