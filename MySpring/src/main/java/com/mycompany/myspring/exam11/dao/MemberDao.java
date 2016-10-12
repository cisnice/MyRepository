package com.mycompany.myspring.exam11.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myspring.exam11.dto.Member;

@Component
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	public void insert(Member member) {
		logger.info("insert() 실행");		
	}
	
	public Member select(String mid) {
		logger.info("select() 실행");	
		return null;
	}
}
