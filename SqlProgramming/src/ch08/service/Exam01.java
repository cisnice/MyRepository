package ch08.service;

import java.util.Date;

import ch08.dto.Member;
import ch08.dao.MemberDao;

public class Exam01 {
	
	public static void main(String[] args) {
		
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		member.setMid("USER7");
		member.setMname("사용자7");
		member.setMage(25);
		member.setMbirth(new Date());
		
		dao.insert(member);		// 자바에서 insert, update, delete 작업하면 자동 커밋된다. 롤백 할 수 없다.
	}
}
