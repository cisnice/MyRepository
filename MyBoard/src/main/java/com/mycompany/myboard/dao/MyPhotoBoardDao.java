package com.mycompany.myboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myboard.dto.MyPhotoBoard;

@Component
public class MyPhotoBoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(MyPhotoBoard myPhotoBoard) {
		String sql = "insert into photoboard(bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype) values(seq_photoboard_bno.nextVal, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		int row = jdbcTemplate.update(sql,
													myPhotoBoard.getBtitle(), 
													myPhotoBoard.getBcontent(), 
													myPhotoBoard.getBwriter(),
													myPhotoBoard.getOriginalfile(), 
													myPhotoBoard.getSavedfile(), 
													myPhotoBoard.getMimetype() );
		return row;
	}
	
	public int update(MyPhotoBoard myPhotoBoard) {
		String sql = "update photoboard set btitle=?, bcontent=?, bhitcount=?, originalfile=?, savedfile=?, mimetype=? where bno=?";
		int row = jdbcTemplate.update(sql,
													myPhotoBoard.getBtitle(), 
													myPhotoBoard.getBcontent(), 
													myPhotoBoard.getBhitcount(),
													myPhotoBoard.getOriginalfile(), 
													myPhotoBoard.getSavedfile(), 
													myPhotoBoard.getMimetype(), 
													myPhotoBoard.getBno() );
		return row;
	}
	
	public int delete(int bno) {
		String sql = "delete from photoboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
	}
	
	public MyPhotoBoard selectByBno(int bno) {
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype from photoboard where bno=?";
		List<MyPhotoBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<MyPhotoBoard>(){
			@Override
			public MyPhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
				MyPhotoBoard myPhotoBoard = new MyPhotoBoard();
				myPhotoBoard.setBno(rs.getInt("bno"));
				myPhotoBoard.setBtitle(rs.getString("btitle"));
				myPhotoBoard.setBcontent(rs.getString("bcontent"));
				myPhotoBoard.setBwriter(rs.getString("bwriter"));
				myPhotoBoard.setBhitcount(rs.getInt("bhitcount"));
				myPhotoBoard.setBdate(rs.getDate("bdate"));
				myPhotoBoard.setOriginalfile(rs.getString("originalfile"));
				myPhotoBoard.setSavedfile(rs.getString("savedfile"));
				myPhotoBoard.setMimetype(rs.getString("mimetype"));
				return myPhotoBoard;
			}
		});
		return (list.size() != 0) ? list.get(0) : null;		
	}

	public List<MyPhotoBoard> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "";
		sql += "SELECT RN, BNO, BTITLE, BHITCOUNT, BDATE, SAVEDFILE ";
		sql += "FROM ( ";
		sql += "      SELECT ROWNUM AS RN, BNO, BTITLE, BHITCOUNT, BDATE, SAVEDFILE ";
		sql += "        FROM ( SELECT BNO, BTITLE, BHITCOUNT, BDATE, SAVEDFILE FROM PHOTOBOARD ORDER BY BNO DESC) ";
		sql += "	       WHERE ROWNUM <= ? ";
		sql += "      ) ";
		sql += "WHERE RN >= ? ";
		
		List<MyPhotoBoard> list = jdbcTemplate.query(sql, 
																	new Object[]{ (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1) },
																	new RowMapper<MyPhotoBoard>() {
			@Override
			public MyPhotoBoard mapRow(ResultSet rs, int row) throws SQLException {				
				MyPhotoBoard photoBoard = new MyPhotoBoard();				
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
		String sql = "select count(*) from photoboard";						
		int count = jdbcTemplate.queryForObject(sql, Integer.class);		   
		return count;																	
	}	
}
