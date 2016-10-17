package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		
		String sql = " SELECT EMPNO, ENAME, SAL*12+NVL(COMM,0) YEARSAL ";
			   sql += " FROM EMP ";
			   sql += " WHERE SAL > ? ";
			   sql += " AND DEPTNO = ? ";
			   sql += " ORDER BY YEARSAL DESC ";
			   
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, 400);
		pstmt.setInt(2, 30);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {														
			int empno = rs.getInt("empno");			 					 
			String ename = rs.getString("ename");	
			int yearsal = rs.getInt("yearsal");
			
			System.out.println(empno + " : " + ename + " : " + yearsal);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
}
