package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam07 {

	public static void main(String[] args) {
		
		List<JobSalary> result = getMethod("사원", 1000);
		for (JobSalary js : result) {
			System.out.println(js.getJob() + " : " + js.getSalary());
		}
	}

	private static List<JobSalary> getMethod(String job, double salary) {
		List<JobSalary> list = new ArrayList<>();
		String sql = "SELECT JOB, SUM(SAL) as salary FROM EMP WHERE JOB != ? GROUP BY JOB HAVING SUM(SAL) >= ? ORDER BY salary";
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			pstmt.setDouble(2, salary);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JobSalary js = new JobSalary();
				js.setJob(rs.getString("job"));
				js.setSalary(rs.getDouble("salary"));
				
				list.add(js);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
