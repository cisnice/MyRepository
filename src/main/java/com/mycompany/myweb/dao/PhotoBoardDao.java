package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(PhotoBoard photoBoard) {
		String sql = "insert into photoboard(bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype) values(seq_photoboard_bno.nextVal, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		int row = jdbcTemplate.update(sql,
													photoBoard.getBtitle(), 
													photoBoard.getBcontent(), 
													photoBoard.getBwriter(),
													photoBoard.getOriginalfile(), 
													photoBoard.getSavedfile(), 
													photoBoard.getMimetype() );
		return row;
	}
	
	public int update(PhotoBoard photoBoard) {
		String sql = "update photoboard set btitle=?, bcontent=?, bhitcount=?, originalfile=?, savedfile=?, mimetype=? where bno=?";
		int row = jdbcTemplate.update(sql,
													photoBoard.getBtitle(), 
													photoBoard.getBcontent(), 
													photoBoard.getBhitcount(),
													photoBoard.getOriginalfile(), 
													photoBoard.getSavedfile(), 
													photoBoard.getMimetype(), 
													photoBoard.getBno() );
		return row;
	}
	
	public int delete(int bno) {
		String sql = "delete from photoboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
	}
	
	public PhotoBoard selectByBno(int bno) {
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype from photoboard where bno=?";
		List<PhotoBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<PhotoBoard>(){
			@Override
			public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
				PhotoBoard photoBoard = new PhotoBoard();
				photoBoard.setBno(rs.getInt("bno"));
				photoBoard.setBtitle(rs.getString("btitle"));
				photoBoard.setBcontent(rs.getString("bcontent"));
				photoBoard.setBwriter(rs.getString("bwriter"));
				photoBoard.setBhitcount(rs.getInt("bhitcount"));
				photoBoard.setBdate(rs.getDate("bdate"));
				photoBoard.setOriginalfile(rs.getString("originalfile"));
				photoBoard.setSavedfile(rs.getString("savedfile"));
				photoBoard.setMimetype(rs.getString("mimetype"));
				return photoBoard;
			}
		});
		return (list.size() != 0) ? list.get(0) : null;		
	}
	
	// 목록 가져오기 - 페이징 처리
	public List<PhotoBoard> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "";
		sql += "SELECT RN, BNO, BTITLE, BHITCOUNT, BDATE, SAVEDFILE ";
		sql += "FROM ( ";
		sql += "      SELECT ROWNUM AS RN, BNO, BTITLE, BHITCOUNT, BDATE, SAVEDFILE ";
		sql += "        FROM ( SELECT BNO, BTITLE, BHITCOUNT, BDATE, SAVEDFILE FROM PHOTOBOARD ORDER BY BNO DESC) ";
		sql += "	       WHERE ROWNUM <= ? ";
		sql += "      ) ";
		sql += "WHERE RN >= ? ";
		
		List<PhotoBoard> list = jdbcTemplate.query(sql, 
																	new Object[]{ (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1) },
																	new RowMapper<PhotoBoard>() {
			@Override
			public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {				
				PhotoBoard photoBoard = new PhotoBoard();				
				photoBoard.setBno(rs.getInt("bno"));
				photoBoard.setBtitle(rs.getString("btitle"));
				photoBoard.setBhitcount(rs.getInt("bhitcount"));
				photoBoard.setBdate(rs.getDate("bdate"));
				photoBoard.setSavedfile(rs.getString("savedfile"));				
				return photoBoard;
			}
		});
		return list;
	}
	
	public int count() {
		String sql = "select count(*) from photoboard";							// count() 함수는 int 값을 반환하기 때문에 JdbcTemplate.queryForObject(String sql, Class<Integer> requiredType) 를 사용한다.
		int count = jdbcTemplate.queryForObject(sql, Integer.class);		// queryForObject 는 하나의 객체를 반환한다. 반드시 하나의 행이나 값이 조회가 되어야 사용가능하다. 다중 값이나 다중 행이 오면 queryForObject 는 사용하지 못한다.   
		return count;																		// 조회된 값이 없으면 예외가 발생해서 사용하지 못한다. query 를 사용한다.
	}	
}
