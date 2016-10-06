package com.mycompany.myspring.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam06Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@RequestMapping("/exam06/index")
	public String index() {
		logger.info("index 출력");
		return "exam06/index";
	} 

	@RequestMapping("/exam06/method1")
	public String method1(HttpServletRequest request) {
		logger.info("method1 출력");
		
		// Client IP 얻기
		logger.info("IP : " + request.getRemoteAddr());
		
		// 브라우저 종류
		logger.info("Browser : " + request.getHeader("User-Agent"));
		if (request.getHeader("User-Agent").contains("Chrome")) {
			logger.info("크롬");
		} else if (request.getHeader("User-Agent").contains("Trident/7.0")) {
			logger.info("익스플로러 11");
		} else if (request.getHeader("User-Agent").contains("MSIE")) {
			logger.info("익스플로러 10 이하");
		}
		
		// 요청 파라미터 값 얻기
		logger.info("mid : " + request.getParameter("mid"));
		logger.info("mname : " + request.getParameter("mname"));
		
		// 쿼리 문자열 얻기
		logger.info("QueryString : " + request.getQueryString());
		logger.info("URI : " + request.getRequestURI());
		logger.info("URL : " +request.getRequestURL());
		
		return "exam06/index";
	}
	
	@RequestMapping("/exam06/method2")
	public String method2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("method2 출력");
		response.setContentType("image/jpg");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"photo1.jpg\"");
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg");
		InputStream is = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while( (byteNum = is.read(values)) != -1) {
			os.write(values, 0, byteNum);			
		}
		os.flush();
		os.close();
		is.close();
		
		return "exam06/index";
	}
	
	@RequestMapping("/exam06/method3")
	public String method3(@RequestHeader("User-Agent") String userAgent) {
		logger.info("method3 출력");
		if ( userAgent.contains("Chrome")) {
			logger.info("크롬");
		} else if ( userAgent.contains("Trident/7.0")) {
			logger.info("익스플로러11");
		} else if ( userAgent.contains("MSIE")) {
			logger.info("익스플로러10 이하");
		}
		return "exam06/index";		
	}
	
	@RequestMapping("/exam06/method4CreateCookie")
	public String method4CreateCookie(HttpServletResponse response) {
		Cookie cookie1 = new Cookie("mid", "fall");
		Cookie cookie2 = new Cookie("mname", "kildong");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);		
		return "exam06/index";
	}
	
	@RequestMapping("/exam06/method4ReceiveCookie1")
	public String method4ReceiveCookie1(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		return "exam06/index";
	}
	
	@RequestMapping("/exam06/method4ReceiveCookie2")
	public String method4ReceiveCookie1(@CookieValue(defaultValue="") String mid, @CookieValue(defaultValue="") String mname) {
		System.out.println("mid : " + mid);
		System.out.println("mname : " + mname);
		return "exam06/index";
	}
	
	@RequestMapping("/exam06/method4DeleteCookie")
	public String method4DeleteCookie(HttpServletResponse response) {
		Cookie cookie1 = new Cookie("mid", "fall");
		Cookie cookie2 = new Cookie("mname", "hongkildong");
		cookie1.setMaxAge(0);
		cookie2.setMaxAge(0);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "exam06/index";
	}
	
	@RequestMapping("/exam06/method5SetObject")
	public String method5SetObject(HttpSession session) {
		Member member = new Member("fall", "hongkildong");
		
		session.setAttribute("member", member);
		return "exam06/index";
	}
	
	@RequestMapping("/exam06/method5GetObject")
	public String method5GetObject(HttpSession session) {		
		Member member = (Member)session.getAttribute("member");
		if(member != null) {
			System.out.println("mid : " + member.getMid());
			System.out.println("mname : " + member.getMname());
		}
		return "exam06/index";
	}
	
	@RequestMapping("/exam06/method5RemoveObject")
	public String method5RemoveObject(HttpSession session) {		
		session.removeAttribute("member");
		return "exam06/index";
	}
}
