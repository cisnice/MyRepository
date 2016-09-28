package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {

	//필드
	private String location;

	//생성자
	public NowServlet() {
		System.out.println("NowServlet 생성자");
	}
	
	//초기화 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("초기화");
		location = config.getInitParameter("location");
		System.out.println(location);				
	}
	
	//메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html;charset=UTF-8");
	
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();		

		pw.println("<html>");
		pw.println("<head><meta charset=UTF-8></head>");
		pw.println("<body>");
		pw.println("Hello  "+ location);
		pw.println("</body>");
		pw.println("</html>");
	}	
}
