package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Board;

public class BoardDao {

	public void insert(Board board) {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "INSERT INTO BOARD(BNO, BTITLE, BCONTENT, BWRITER, BHITCOUNT, BDATE) ";
			       sql += "VALUES(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBwriter());
			pstmt.setInt(5, board.getBhitcount());
			pstmt.setDate(6, new Date(board.getBdate().getTime()));			
			
			int rowNo = pstmt.executeUpdate();		
			
			if (rowNo == 1) {
				System.out.println("삽입 성공");
			}
			
			pstmt.close();
			
		} catch (Exception e) {			
			System.out.println("삽입 실패");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void update(Board board) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "UPDATE BOARD SET BTITLE=?, BCONTENT=?, BWRITER=?, BHITCOUNT=?, BDATE=? WHERE BNO=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setInt(4, board.getBhitcount());
			pstmt.setDate(5, new Date(board.getBdate().getTime()));
			pstmt.setInt(6, board.getBno());
			
			int rowNo = pstmt.executeUpdate();		
			
			if (rowNo >= 1) {
				System.out.println("수정 성공");
			} else if(rowNo == 0) {
				System.out.println("수정 없음");
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

	public void deleteByBno(int bno) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "DELETE FROM BOARD WHERE BNO=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			
			pstmt.setInt(1, bno);
			
			int rowNo = pstmt.executeUpdate();		
			
			if (rowNo >= 1) {
				System.out.println("삭제 성공");
			} else if(rowNo == 0) {
				System.out.println("삭제 없음");
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
