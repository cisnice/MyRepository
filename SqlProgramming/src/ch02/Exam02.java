package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {		
		
		Class.forName("oracle.jdbc.OracleDriver"); 		// Class.forName 은 "oracle.jdbc.OracleDriver" 를 메모리에 올려놓는 작업. 
																		// class OracleDriver{
		                                                                //       static {   // 메모리에 올라갈 때 실행
		                                                                //        	Driver oracleDriver = new OracleDriver();
																		//			DriverManager.registerDriver(oracleDriver);       //OracleDriver 객체를 DriverManager에 등록하는 코드
		                                                                //       }
																		//	}
																		// DriverManager가 메모리에 있는 OracleDriver 을 로딩한다.
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		
		/*
		Driver oracleDriver = new OracleDriver();			
		DriverManager.registerDriver(oracleDriver);		// Class.forName 을 사용하지 않을려면 이와 같이 객체를 만들어 Driver에 등록해 준다.
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		*/
		
		// 매개변수화된 SQL문
		String sql = " SELECT ENAME, EMPNO, SAL FROM EMP WHERE ENAME LIKE ? ";   // 수시로 바뀔 수 있는 값에 ? 를 넣어 매개변수 처럼 사용.
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%성%");						// the first parameter is 1, the second is 2, ... (int index, String 값), 값에 일부분만 ? 할수 없다. 
		ResultSet rs = pstmt.executeQuery();			// cursor 가 before first 에 위치. after last 까지 읽어서 false가 반환되면 종료
		while(rs.next()) {										// next - 다음줄 내려가서 데이터 읽음. 데이터가 있으면 true, 없으면 false 반환				
			int empno = rs.getInt(2);						// select 문의 출력 순서대로 인덱스를 가진다. 					 
			String ename = rs.getString("ename");	// 출력 순서와 상관없이 ename 필드를 가져온다.
			int sal = rs.getInt("sal");
			
			System.out.println(empno + " : " + ename + " : " + sal);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		
		
	}
}
