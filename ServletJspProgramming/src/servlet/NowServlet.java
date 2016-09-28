package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet{		
	
	//필드
	private String location;	
	
	//생성자
	public NowServlet(){
		System.out.println("NowServlet 객체 생성");			// 한번 객체가 생성되면 다시 생성되지 않고 재사용된다.
	}																		// Client가 최초로 요청할 때 객체 생성되고 재사용된다.	웹에서 now로 접속했을때 생성됨	
	
	//초기화 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {							// 객체가 생성되면서 같이 실행된다. init-param을 받기위해 실행됨
		System.out.println("NowServlet 초기화");
		location = config.getInitParameter("location");		// param-value 출력됨
		System.out.println(location);
	}
	
	//메소드	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		//클라이언트가 Get방식으로 서버에 요청하고 서버에서 응답 보낼 때 사용             
		response.setContentType("text/html;charset=UTF-8");		//Client에 보낼 Content-Type 설정. 공백 없어야함
//		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
//		OutputStream os = response.getOutputStream();				// 바이트 기반. 문자, 이미지 등 모든 것을 본문에 실어 보낸다.
		PrintWriter out = response.getWriter();							// print(), println() 등을 출력하기 위해. 문자열을 본문에 실어 보낸다.
		out.println("<html>");
		out.println("<head><meta charset='UTF-8'></head>");
		out.println("<body>");
		out.println("현재 : " + location + "  시간 : " + new Date().toString());
		out.println("</body>");
		out.println("</html>");
		
	}

}
