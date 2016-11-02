package com.mycompany.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myboard.dao.MyBoardMemberDao;
import com.mycompany.myboard.dto.MyBoardMember;

@Component
public class MyBoardMemberService {
	
	public static final int JOIN_SUCCESS = 0;
	public static final int JOIN_FAIL = 1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	public static final int LOGOUT_SUCCESS = 0;
	public static final int LOGOUT_FAIL_MID = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int WITHDRAW_SUCCESS = 0;
	public static final int WITHDRAW_FAIL = 1;
	
	@Autowired
	MyBoardMemberDao myBoardMemberDao;
	
	public int login(String mid, String mpassword) {
		MyBoardMember member = myBoardMemberDao.selectByMid(mid);
		if( member == null ) {								
			return LOGIN_FAIL_MID;
		} 
		
		if ( member.getMpassword().equals(mpassword) == false ) {
			return LOGIN_FAIL_MPASSWORD;
		}
		return LOGIN_SUCCESS;
	}
	
	public int join(MyBoardMember member) {					
		myBoardMemberDao.insert(member);
		return JOIN_SUCCESS;
	}
	
	public int logout(String mid) {	  
		return LOGOUT_SUCCESS;
	}

	public String findMid(String memail) {
		return myBoardMemberDao.selectByMemail(memail);
	}
	
	public String findMpassword(String mid, String memail) {
		MyBoardMember member = myBoardMemberDao.selectByMid(mid);
		if ( member == null ) {
			return null;
		}		
		if ( member.getMemail().equals(memail) == false ) {
			return null;
		}		
		return member.getMpassword();
	}
	
	public MyBoardMember info(String mid, String mpassword) {				
		MyBoardMember member = myBoardMemberDao.selectByMid(mid);
		if ( member.getMpassword().equals(mpassword) == false ) {
			return null;
		}
		return member;
	}
	
	public int modify(MyBoardMember member) {					 
		MyBoardMember dbMember = myBoardMemberDao.selectByMid(member.getMid());
		if ( dbMember.getMpassword().equals(member.getMpassword()) == false ) { 	
			return MODIFY_FAIL;
		}
		int row = myBoardMemberDao.update(member);
		if ( row != 1 ) {
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}
	
	public int withdraw(String mid, String mpassword) {		
		MyBoardMember member = myBoardMemberDao.selectByMid(mid);
		if ( member.getMpassword().equals(mpassword) == false ) {
			return WITHDRAW_FAIL;
		}
		myBoardMemberDao.delete(mid);
		logout(mid);		
		return WITHDRAW_SUCCESS;
	}
	
	public boolean isMid(String mid) {							 
		MyBoardMember member = myBoardMemberDao.selectByMid(mid);
		if ( member == null ) {
			return false;
		}
		return true;
	}
}
