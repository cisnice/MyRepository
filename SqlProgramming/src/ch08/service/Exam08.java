package ch08.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ch08.dao.AccountDao;
import ch08.dto.Account;

public class Exam08 {
	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			// 트랜잭션 작업을 시작
			conn.setAutoCommit(false); 			// insert, update, delete 하면 자동 커밋 된다. 절대 롤백할 수 없다. 자동 커밋을 false 로 둬서 자동 커밋되지 않게한다.
			
			AccountDao accountDao = new AccountDao();
			accountDao.setConn(conn);			// 두 작업이 Connection 이 다르면 트랜잭션이 안되기 때문에 Dao 에 setter 주입해서 하나의 Connection 을 사용한다.
			
			// 작업1
			Account account1 = new Account();
			account1.setAno("111-111");
			account1.setAbalance(500000);
			
			int rowNo1 = accountDao.update(account1);			
			
			// 작업2
			Account account2 = new Account();
			account2.setAno("111-113");
			account2.setAbalance(200000);
			
			int rowNo2 = accountDao.update(account2);
			
			if (rowNo1 == 1 && rowNo2 == 1) {
				conn.commit();
				System.out.println("계좌이체 성공");
			} else {
				conn.rollback();
				System.out.println("계좌가 존재하지 않아서 계좌이체 실패함");
			}
			
		} catch (Exception e) {			
			try {
				conn.rollback();
			} catch (SQLException e1) { }
			System.out.println("예외가 발생하여 계좌이체 실패함");
		} finally {
			try {
				conn.setAutoCommit(true);			// 모든 작업이 끝나면 반드시 true 로 변경해준다.				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
}
