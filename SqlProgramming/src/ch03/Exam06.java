package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam06 {

	public static void main(String[] args) {
		
		Employee employee = getEmployee(1001);
		System.out.println(employee.getEmpno() + " : " + employee.getEname() + " : " + employee.getSal());
		
		List<Department> result = getDepartment("개발");
		for(Department dept : result){
			System.out.println(dept.getDeptno() + " : " + dept.getDname() + " : " + dept.getLoc());			
		}
	}

	private static Employee getEmployee(int searchEmpno) {
		Employee emp = new Employee();
		
		Connection conn = null;    // null 초기화를 하지 않으면 메모리에 올라가지 않아 try 에서 에러가 나서 finally에서 close 할때 에러가 난다.
		try {
			Class.forName("oracle.jdbc.OracleDriver");		// *.jar 파일을 만들때 옵션을 주면 자동 로딩이 되게 할 수 있다.
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
			
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, searchEmpno);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
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
		return emp;
	}
	
	private static List<Department> getDepartment(String searchDname) {		
		List<Department> list = new ArrayList<>();
		Connection conn = null;
		
		try {			
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "SELECT * FROM DEPT WHERE DNAME LIKE ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchDname + "%");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Department dept = new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				list.add(dept);
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
