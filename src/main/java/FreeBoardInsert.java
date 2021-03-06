import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FreeBoardInsert {
	public static void main(String[] args) throws Exception {
		
		// freeboard 에 데이터 삽입
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@106.253.56.123:1521:orcl", "kosauser6", "kosa12345");
		String sql = "insert into freeboard(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(seq_freeboard_bno.nextval, ?, ?, ?, 0, sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=1; i<=100; i++) {
			pstmt.setString(1, "제목"+i);
			pstmt.setString(2, "내용"+i);
			pstmt.setString(3, "user1");
			pstmt.executeUpdate();
		}
		pstmt.close();
		conn.close();
	}
}
