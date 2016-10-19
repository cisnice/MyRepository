package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Member;

public class MemberDao {

	public void insert(Member member) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "INSERT INTO MEMBER(MID, MNAME, MAGE, MBIRTH) ";
					sql += "VALUES(?, ?, ?, ?)";					
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setInt(3, member.getMage());
			pstmt.setDate(4, new Date(member.getMbirth().getTime()));		
			// member의 mbirth 는 java.util.Date 고 setDate는 java.sql.Date 를 사용. sql이 util의 상속을 받는다. long 값을 쓰면 해결. 
			// getTime() 메소드가 long 으로 변환시킨다. 
			
//			pstmt.executeQuery();   // select 실행할 때 사용
			int rowNo = pstmt.executeUpdate();		// Insert, update, delete 실행	   
			
			if(rowNo == 1){
				System.out.println("저장성공");				
			}	
			
			pstmt.close();
					
		} catch (Exception e) {
			System.out.println("저장실패");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}

	public void update(Member member) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "UPDATE MEMBER SET MAGE=?, MBIRTH=? WHERE MID=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMage());
			pstmt.setDate(2, new Date(member.getMbirth().getTime()));
			pstmt.setString(3, member.getMid());
			
			int rowNo = pstmt.executeUpdate();	   	// UPDATE 문은 변경된 행의 개수가 리턴된다. 
																	// 조건이 만족하지 못하면 0 이 리턴 (수정된 행이 없을 경우)
																	// 예외 발생(문법 오류)                
			
			if(rowNo >= 1){      
				System.out.println(rowNo + " 행이 수정됨");				
			} else if(rowNo == 0) {
				System.out.println("수정된 행이 없음");
			}
			
			pstmt.close();
					
		} catch (Exception e) {
			System.out.println("수정 실패");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}

	public void deleteByMid(String mid) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "DELETE FROM MEMBER WHERE MID=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			
			int rowNo = pstmt.executeUpdate();	   
			
			if(rowNo >= 1){      
				System.out.println(rowNo + " 행이 삭제됨");				
			} else if(rowNo == 0) {
				System.out.println("삭제된 행이 없음");
			}
			
			pstmt.close();
					
		} catch (Exception e) {
			System.out.println("삭제 실패");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
	}
}













