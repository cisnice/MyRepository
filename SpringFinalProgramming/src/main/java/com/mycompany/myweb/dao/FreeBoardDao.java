package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.FreeBoard;

// 스프링을 사용해서 좋은점 - 의존성 관리가 수월하다.  JdbcTemplate(connection, preparedStatement, resultSet을 대체) 같은 객체를 사용해서 코드를 많이 줄여준다.

@Component
public class FreeBoardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(FreeBoard freeBoard) {
		String sql = "insert into freeboard(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(seq_freeboard_bno.nextVal, ?, ?, ?, 0, sysdate)";
		int row = jdbcTemplate.update(sql,
													freeBoard.getBtitle(), 
													freeBoard.getBcontent(), 
													freeBoard.getBwriter() );
		return row;
	}
	
	public int update(FreeBoard freeBoard) {
		String sql = "update freeboard set btitle=?, bcontent=?, bhitcount=? where bno=?";
		int row = jdbcTemplate.update(sql,
													freeBoard.getBtitle(), 
													freeBoard.getBcontent(), 
													freeBoard.getBhitcount(), 
													freeBoard.getBno() );
		return row;
	}
	
	public int delete(String bno) {
		String sql = "delete from freeboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
	}
	
	public FreeBoard selectByBno(int bno) {
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from freeboard where bno=?";
		List<FreeBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<FreeBoard>(){
			@Override
			public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
				FreeBoard freeBoard = new FreeBoard();
				freeBoard.setBno(rs.getInt("bno"));
				freeBoard.setBtitle(rs.getString("btitle"));
				freeBoard.setBcontent(rs.getString("bcontent"));
				freeBoard.setBwriter(rs.getString("bwriter"));
				freeBoard.setBhitcount(rs.getInt("bhitcount"));
				freeBoard.setBdate(rs.getDate("bdate"));
				return freeBoard;
			}
		});
		return (list.size() != 0) ? list.get(0) : null;		
	}
	
	// 목록 가져오기 - 페이징 처리
	public List<FreeBoard> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "";
		sql += "SELECT RN, BNO, BTITLE, BWRITER, BHITCOUNT, BDATE ";
		sql += "FROM ( ";
		sql += "      SELECT ROWNUM AS RN, BNO, BTITLE, BWRITER, BHITCOUNT, BDATE ";
		sql += "        FROM ( SELECT BNO, BTITLE, BWRITER, BHITCOUNT, BDATE FROM FREEBOARD ORDER BY BNO DESC) ";
		sql += "	       WHERE ROWNUM <= ? ";
		sql += "      ) ";
		sql += "WHERE RN >= ? ";
		
		List<FreeBoard> list = jdbcTemplate.query(sql, 
																	new Object[]{ (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1) },
																	new RowMapper<FreeBoard>() {
			@Override
			public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {				
				FreeBoard freeBoard = new FreeBoard();
				freeBoard.setBno(rs.getInt("bno"));
				freeBoard.setBtitle(rs.getString("btitle"));
				freeBoard.setBwriter(rs.getString("bwriter"));
				freeBoard.setBhitcount(rs.getInt("bhitcount"));
				freeBoard.setBdate(rs.getDate("bdate"));
				return freeBoard;
			}
		});
		return list;
	}
	
	public int count() {
		String sql = "select count(*) from freeboard";							// count() 함수는 int 값을 반환하기 때문에 JdbcTemplate.queryForObject(String sql, Class<Integer> requiredType) 를 사용한다.
		int count = jdbcTemplate.queryForObject(sql, Integer.class);		// queryForObject 는 하나의 객체를 반환한다. 반드시 하나의 행이나 값이 조회가 되어야 사용가능하다. 다중 값이나 다중 행이 오면 queryForObject 는 사용하지 못한다.   
		return count;																		// 조회된 값이 없으면 예외가 발생해서 사용하지 못한다. query 를 사용한다.
	}																							// 뒤에 오는 type으로 객체를 반환한다(Integer 객체). Integer로 받아야 하지만 int 로 자동 형 변환이 이루어진다.  
	
}
