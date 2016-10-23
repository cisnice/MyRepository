package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Member;

public class MemberDao {
	private Connection conn;
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int insert(Member member) throws SQLException {			// insert 된 행의 수가 리턴. 1 아니면 예외
		String sql = "INSERT INTO MEMBER(MID, MNAME, MPASSWORD, MAGE, MBIRTH) VALUES(?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMname());
		pstmt.setString(3, member.getMpassword());
		pstmt.setInt(4, member.getMage());
		pstmt.setDate(5, new Date(member.getMbirth().getTime()));		// Date는 sql Date. long 값으로 처리
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		
		return rowNo;
	}
	
	public Member selectByMid(String mid) throws SQLException {			// id는 유일하기 때문에 하나의 행만 출력하기 때문에 member 객체를 return 한다.
		String sql = "SELECT MID, MNAME, MPASSWORD, MAGE, MBIRTH FROM MEMBER WHERE MID = ?";
		
		Member member = null;
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);		
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
		}
		rs.close();
		pstmt.close();
		
		return member;
	}
	
	public List<Member> selectByMname(String mname) throws SQLException {		// 이름은 여러명일수 있기 때문에 List를 return 한다. 결과가 없다면 비어있는 List 가 리턴된다.
		String sql = "SELECT MID, MNAME, MPASSWORD, MAGE, MBIRTH FROM MEMBER WHERE MNAME LIKE ?";
		List<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + mname + "%");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {	
			Member member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
			
			list.add(member);
		}
		rs.close();
		pstmt.close();
		
		return list;
	}
	
	public int update(Member member) throws SQLException {			// update 된 행의 수가 리턴. 1이상, 0, 예외
		String sql = "UPDATE MEMBER SET MNAME=?, MPASSWORD=?, MAGE=?, MBIRTH=? WHERE MID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);		
		pstmt.setString(1, member.getMname());
		pstmt.setString(2, member.getMpassword());
		pstmt.setInt(3, member.getMage());		
		pstmt.setDate(4, new Date(member.getMbirth().getTime()));
		pstmt.setString(5, member.getMid());
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public int deleteByMid(String mid) throws SQLException {			// delete 된 행의 수가 리턴. 1, 0, 예외
		String sql = "DELETE FROM MEMBER WHERE MID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();		
		
		return rowNo;
	}
}
