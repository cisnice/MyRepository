package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 어떤 JDBC Driver를 사용할 것인가 (JDBC Driver 로딩)
		Class.forName("oracle.jdbc.OracleDriver");					//클래스를 메모리에 올리는 작업. 10g ~ -> ojdbcXX.jar. 10g 부터 jdbc 안에 있는 Driver 를 사용한다.
		//Class.forName("oracle.jdbc.driver.OracleDriver");			// 8i, 9i -> classXX.jar. jdbc.driver 패키지 안에 있는 Driver 와  jdbc 안에 있는 Driver는 같은 파일이다. 
		
		// 연결 요청을 해서 연결 객체를 얻기
		
		// getConnection(String url) 은 url 에 ip/port/db명/id/pw 까지 모든 정보가 들어있을때 사용
		// Connection conn = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@myhost:1521:orcl);
		
		// getConnection(String url, String user, String password) 은 url 에 ip/port/db명 까지 포함하고 id, pw 는 따로 매개변수로 준다.
		// Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:orcl", "scott", "tiger");
		
		// oracle jdbc connection url 구글 검색. JDBC Driver 마다 다르다.
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		
		// SQL문을 보내고 실행시키기
		String sql = "select empno, ename from emp where empno=1001";		
		PreparedStatement pstmt = conn.prepareStatement(sql);		// 실행 준비. pstmt 에 준비된 객체가 저장된다. 커서가 컬럼명에서 준비
		ResultSet rs = pstmt.executeQuery();			// ResultSet 리턴. sql 문 실행 결과. next 하면 다음줄로 내려가서 데이터를 읽는다. 
		
		// 결과셋에서 한 행씩 읽기
		while (rs.next()) {						// next - 커서 이동. 커서가 내려가서 데이터가 있으면 true, 없으면 false
			String empno = rs.getString("empno"); 
			String ename = rs.getString("ename");
			System.out.println(empno + " : " + ename);
		}
		
		// JDBC 관련 객체 닫기(메모리 리소스 해제)
		rs.close();
		pstmt.close();
		conn.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
