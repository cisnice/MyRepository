package com.mycompany.myweb.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;

@Component
public class MemberService {		// 사용할 기능들을 정의
	
	public static final int JOIN_SUCCESS = 0;
	public static final int JOIN_FAIL = 1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	public static final int LOGOUT_SUCCESS = 0;
	public static final int LOGOUT_FAIL_MID = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL_MID = 1;
	
	public static final int WITHDRAW_SUCCESS = 0;
	public static final int WITHDRAW_FAIL = 1;

	@Autowired
	private MemberDao memberDao;
	
	public int join(Member member) {						// 정상 가입이 될 경우 1, 아니면 예외		
		memberDao.insert(member);
		return JOIN_SUCCESS;
	}
	
	public int login(String mid, String mpassword, HttpSession session) {		// 1. mid 가 없을 경우, 2. password가 틀릴 경우, 3. 둘다 일치 할 경우. 상수 선언하여 리턴한다.
		Member member = memberDao.selectByMid(mid);
		if( member == null ) {								// mid 가 없을 경우
			return LOGIN_FAIL_MID;
		} 
		
		if ( member.getMpassword().equals(mpassword) == false ) {		// password 가 틀릴 경우
			return LOGIN_FAIL_MPASSWORD;
		}
		
		session.setAttribute("login", mid);
		return LOGIN_SUCCESS;
	}
	
	public int logout(HttpSession session) {			// 로그인 정보는 session에 저장된다. 클라이언트마다 session이 생기기 때문에 로그아웃할때는 session 만 삭제하면 된다.  
		session.removeAttribute("login");
		return LOGOUT_SUCCESS;
	}

	public String findMpassword(String mid, String memail) {
		Member member = memberDao.selectByMid(mid);
		if ( member == null ) {
			return null;
		}
		
		if ( member.getMemail().equals(memail) == false ) {
			return null;
		}
		
		return member.getMpassword();
	}
	
	public String findMid(String memail) {
		return memberDao.selectByMemail(memail);
	}
	
	public Member info(String mpassword, HttpSession session) {					// login 상태에서 정보를 보여주는 것이므로 session에 저장된 정보를 가져온다. 정보 확인할 때 비번을 물어보는 경우가 있으므로 매개변수로 선언
		String mid = (String) session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if ( member.getMpassword().equals(mpassword) == false ) {
			return null;
		}
		return member;
	}
	
	public int modify(Member member) {						// login 상태에서 수정. 바뀐 내용만 DB에 저장. 
		
	}
	
	public int withdraw(String mpassword, HttpSession session) {					// login 상태에서 탈퇴. 비번을 한번 더 묻는다. 1. 탈퇴 성공 2. 비번이 틀리면 실패
		String mid = (String) session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if ( member.getMpassword().equals(mpassword) == false ) {
			return WITHDRAW_FAIL;
		}
		memberDao.delete(mid);
		logout(session);		
		return WITHDRAW_SUCCESS;
	}
	
	public boolean isMid(String mid) {								// 가입된 mid가 있는지 검사 
		
	}
}

