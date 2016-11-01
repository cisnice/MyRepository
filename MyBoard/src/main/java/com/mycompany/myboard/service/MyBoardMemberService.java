package com.mycompany.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myboard.dao.MyBoardMemberDao;
import com.mycompany.myboard.dto.MyBoardMember;

@Component
public class MyBoardMemberService {
	
	public static final int LOGIN_SUCCESS=0;
	public static final int LOGIN_FAIL_MID=1;
	
	@Autowired
	MyBoardMemberDao myBoardMemberDao;
	
	public int login(String mid) {
		MyBoardMember member = myBoardMemberDao.selectByMid(mid);
		if(member == null){
			return LOGIN_FAIL_MID;
		} 
		return LOGIN_SUCCESS;
	}

}
