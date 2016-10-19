package ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Account;

public class AccountDao {			// Dao 에 Connection 을 하는 코드가 들어가면 안된다. setter 주입 받는다.
												// try ~ catch 로 예외처리하면 안됨. throws 를 해야한다.
												// try ~ catch 하면 예외가 발생해도 전부 처리하기 때문에 트랜잭션 할 수 없다.
	
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}	
	
	public int update(Account account) throws SQLException {
		String sql = "UPDATE ACCOUNT SET ABALANCE=? WHER ANO=?";		
		PreparedStatement pstmt = conn.prepareStatement(sql);			
		pstmt.setInt(1, account.getAbalance());
		pstmt.setString(2, account.getAno());
		
		int rowNo = pstmt.executeUpdate();
		
		return rowNo;
	}
}
