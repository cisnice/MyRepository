package com.mycompany.myapp.exam11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dao.Exam11MemberDao;
import com.mycompany.myapp.exam11.dto.Member;

@Component			// 관리 객체 이름으로 중복 생성되면 처음에 생성된 객체만 유효. 
public class Exam11MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberService.class);
	
	public static final int LOGIN_SUCCESS = 0;					// 상수는 static final로 선언, 상수명은 대문자, 상수명 연결은 (_)
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	@Autowired
	private Exam11MemberDao memberDao;
	
	public  void join(Member member) {
		logger.info("join 처리");
		memberDao.insert(member);								// DB 에 회원정보 삽입
	}
	
	public int login(String mid, String mpassword) {
		logger.info("login 처리");
		Member member = memberDao.select(mid);		// DB에서 회원정보 찾기
		if(member == null) {
			return LOGIN_FAIL_MID;
		} else {
			if ( member.getMpassword().equals(mpassword) ) {
				return LOGIN_SUCCESS;
			} else {
				return LOGIN_FAIL_MPASSWORD;
			}
		}
	}
		
}
