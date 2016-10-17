package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		
		// 검색할 이름 입력
		// 사번, first_name 출력		
//		Scanner scan = new Scanner(System.in);
//
//		Connection conn = null;
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");			
//			
//			while (true) {
//				System.out.print("검색할 이름 : ");
//				String name = scan.nextLine();			
//				
//				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "kosa12345");	
//				
//				String sql = " SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES WHERE LOWER(FIRST_NAME) LIKE ? ";
//				   
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				
//				pstmt.setString(1, "%" + name + "%");
//				
//				ResultSet rs = pstmt.executeQuery();
//				
//				while(rs.next()) {
//					int EMPLOYEE_ID = rs.getInt("EMPLOYEE_ID");
//					String FIRST_NAME = rs.getString("FIRST_NAME");
//					System.out.println(EMPLOYEE_ID + " : " + FIRST_NAME );
//				}
//				
//				rs.close();
//				pstmt.close();
//				conn.close();				
//			}
//		} catch(Exception e) {
//			try { conn.close(); } catch (SQLException e2) {}
//			e.printStackTrace();
//		} 
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("검색할 이름 : ");
			String name = scan.nextLine();
			List<Employee> result = getList(name);	
			
			for (Employee emp : result){
				System.out.println(emp.getEmpno() + " : " + emp.getEname());
			}

		}
	}
	
	public static List<Employee> getList(String searchName) {
		List<Employee> list = new ArrayList<>();

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");			
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");	
			
			String sql = " SELECT * FROM EMP WHERE ENAME LIKE ? ";
			   
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + searchName + "%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				int EMPLOYEE_ID = rs.getInt("EMPLOYEE_ID");
//				String FIRST_NAME = rs.getString("FIRST_NAME");
//				System.out.println(EMPLOYEE_ID + " : " + FIRST_NAME );
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				list.add(emp);
			}
			
			rs.close();
			pstmt.close();
			conn.close();				
			
		} catch(Exception e) {
			try { conn.close(); } catch (SQLException e2) {}
			e.printStackTrace();
		} 
	
		return list;
	}
}

