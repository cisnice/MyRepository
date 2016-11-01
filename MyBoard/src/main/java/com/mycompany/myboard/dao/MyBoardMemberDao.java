package com.mycompany.myboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myboard.dto.MyBoardMember;



@Component
public class MyBoardMemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MyBoardMember selectByMid(String mid) {
		String sql = "select mid, mname, mpassword, maddress, mtel, memail from member where mid=?";
		
		List<MyBoardMember> list = jdbcTemplate.query(sql, new Object[]{mid}, new RowMapper<MyBoardMember>(){

			@Override
			public MyBoardMember mapRow(ResultSet rs, int row) throws SQLException {
				MyBoardMember member = new MyBoardMember();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMaddress(rs.getString("maddress"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				return member;
			}
		});
		return list.size() != 0 ? list.get(0) : null;
	}
}
