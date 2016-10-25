package com.mycompany.myapp.exam13.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam13.dto.Member;

@Component
public class Exam13MemberDao {	

	@Autowired
	private JdbcTemplate jdbcTemplate;			// jdbcTemplate은 스프링 안에서만 사용 가능하다
	
	public int insert(Member member) {			
		String sql = "INSERT INTO MEMBER(MID, MNAME, MPASSWORD, MAGE, MBIRTH) VALUES(?, ?, ?, ?, ?)";
		int rowNo = jdbcTemplate.update(
				sql, 
				member.getMid(), 
				member.getMname(), 
				member.getMpassword(), 
				member.getMage(), 
				member.getMbirth()
		);
		return rowNo;
	}
	
	public Member selectByMid(String mid) {			
		String sql = "SELECT MID, MNAME, MPASSWORD, MAGE, MBIRTH FROM MEMBER WHERE MID = ?";		
		List<Member> list = jdbcTemplate.query(
				sql, 
				new Object[] {mid},
				new RowMapper<Member>() {																		// rowMapper - 객체로 만들 때 실제 테이블에 있는 컬럼명과 필드의 명을 맵핑 시킨다.
					@Override																								// List 타입을 리턴하지만 하나의 객체를 전달 하기 위해서도 사용 가능하다.
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {		// mapRow - 조회된 행의 수만큼 실행, 각 행마다 member 객체를 만든다.
						Member member = new Member();
						member.setMid(rs.getString("mid"));
						member.setMname(rs.getString("mname"));
						member.setMpassword(rs.getString("mpassword"));
						member.setMage(rs.getInt("mage"));
						member.setMbirth(rs.getDate("mbirth"));
						return member;
					}
				}
		);				
		return (list.size() != 0) ? list.get(0) : null;			// mid가 pk 이기때문에 조건이 만족했다면 하나의 객체 리턴. 만족하지 못했다면 null 리턴
	}
	
	/*
	public List<Member> selectByMname(String mname) throws SQLException {		
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
	
	public int update(Member member) throws SQLException {			
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
	
	public int deleteByMid(String mid) throws SQLException {		
		String sql = "DELETE FROM MEMBER WHERE MID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		
		int rowNo = pstmt.executeUpdate();
		pstmt.close();		
		
		return rowNo;
	}*/
}
