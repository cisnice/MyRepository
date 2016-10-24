package com.mycompany.myapp.exam12.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam12.dao.MemberDao;
import com.mycompany.myapp.exam12.dto.Member;

@Component
public class Exam12Service {
	private static final Logger logger = LoggerFactory.getLogger(Exam12Service.class);
	
	@Autowired
	private DataSource dataSource;	  // DataSource 인터페이스를 구현한 관리객체가 자동으로 들어온다.  
 												 // servlet-context.xml 에 설정한 Connection Pool 에서 생성한 dataSource 객체가 주입된다.
	@Autowired
	private MemberDao dao;

	public void join(Member member) {
		Connection conn = null;
		try {
//			Class.forName("oracle.jdbc.OracleDriver"); 		// /SpringProgramming/src/main/webapp/WEB-INF/lib/ojdbc6.jar 파일 넣어줘야 OracleDriver가 동작한다.
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");			
			
			conn = dataSource.getConnection();		// connection 대여.  
			dao.setConn(conn);				
			
			int rowNo = dao.insert(member);
			logger.info(rowNo + "행이 저장됨");
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			try {								
				conn.close();					// connection 반납. 연결을 끊겠다는 것이 아님
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
	}

}
