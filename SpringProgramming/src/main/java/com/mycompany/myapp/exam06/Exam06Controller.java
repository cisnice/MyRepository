package com.mycompany.myapp.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
@RequestMapping("/exam06")
public class Exam06Controller {

	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@RequestMapping("/index")
	public String index() {		
		logger.info("index 요청처리");
		return "exam06/index";		
	}
	
	@RequestMapping("/method1")				//HttpServletRequest 변수 선언
	public String method1(HttpServletRequest request) {		// 요청 HTTP 에 대한 모든 내용을 담고 있다. 시작행, 헤더행의 내용 전부 
		logger.info("method1 요청 처리");
		
		// 클라이언트의 IP 얻기
		logger.info("WebClient IP : " + request.getRemoteAddr());
		
		// 클라이언트의 브라우저 종류 얻기
		logger.info("WebClient 종류 : " + request.getHeader("User-Agent"));
		if(request.getHeader("User-Agent").contains("Chrome")) {
			logger.info("브라우저 종류 : 크롬");
		} else if(request.getHeader("User-Agent").contains("Trident/7.0")) {
			logger.info("브라우저 종류 : 인터넷 익스플로러 11");
		} else if(request.getHeader("User-Agent").contains("MSIE")) {
			logger.info("브라우저 종류 : 인터넷 익스플로러 10 이하");
		}
		
		// 요청 파라미터 값 얻기
		logger.info("mid : " + request.getParameter("mid"));							//jsp 에서 사용. spring에서는 사용하지 않음
		logger.info("mname : " + request.getParameter("mname"));
		
		// 쿼리 문자열 얻기
		logger.info("QueryString : " + request.getQueryString());
		logger.info("요청 URI : " + request.getRequestURI());
		logger.info("요청 URL : " + request.getRequestURL());
		logger.info("요청 방식 : " + request.getMethod());
		logger.info("시스템 파일 경로 : " + request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg"));
		
		return "exam06/index";
	}
	
	@RequestMapping("/method2")			// HttpServletResponse 변수 선언
	public void method2(HttpServletRequest request, HttpServletResponse response) throws IOException {		 
//		response.setContentType("application/json;charset=UTF-8");
////		OutputStream os = response.getOutputStream();
//		PrintWriter pw = response.getWriter();
//		
//		pw.println("{mid:'fall', mname:'한가을'}");
//		pw.flush();	//자동으로 flush, close 가 발생해서 따로 해주지 않아도 된다. 일회성이다.
//		pw.close();
		
		response.setContentType("image/jpeg");
		String fileName = "사진2.jpg";
		fileName = URLEncoder.encode(fileName, "UTF-8");																// 파일명이 한글일 경우 브라우저에서 인식을 못하기 때문에 인코딩해서 파일 명에 넣어준다.
//		response.setHeader("Content-Disposition", "attachment; filename=\"사진2.jpg\"");					// 링크 눌렀을 때 다운로드. \"\" 안의 문자 전체가 파일명. 
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");		
		
		OutputStream os = response.getOutputStream();
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/사진2.jpg");
		InputStream is = new FileInputStream(filePath);
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while( (byteNum = is.read(values)) !=-1 ) {
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close();
		os.close();		
	}	
	
	@RequestMapping("/method3")
	public String method3(@RequestHeader("User-Agent") String userAgent) {		// @RequestHeader 를 이용해서 클라이언트의 브라우저 종류 얻기		
		if(userAgent.contains("Chrome")) {
			logger.info("브라우저 종류 : 크롬");
		} else if(userAgent.contains("Trident/7.0")) {
			logger.info("브라우저 종류 : 인터넷 익스플로러 11");
		} else if(userAgent.contains("MSIE")) {
			logger.info("브라우저 종류 : 인터넷 익스플로러 10 이하");
		}
		return "exam06/index";	
	}
	
	@RequestMapping("/method4CreateCookie")						
	public String method4CreateCookie(HttpServletResponse response) throws UnsupportedEncodingException {
		// 쿠키 생성
		Cookie cookie1 = new Cookie("mid", "fall");
		
		String name = "홍길동";
		name = URLEncoder.encode(name, "UTF-8");		
		Cookie cookie2 = new Cookie("mname", name);		// 한글을 저장할 수 없다. 인코딩해서 넣어준다.
		cookie2.setMaxAge(60);
		
		// 쿠키 보내기(저장) - 응답 헤더에 쿠키 정보를 저장
		response.addCookie(cookie1);
		response.addCookie(cookie2);		
		
		return "exam06/index";	
	}
	
	@RequestMapping("/method4ReceiveCookieHow1")						
	public String method4ReceiveCookieHow1(HttpServletRequest request) throws UnsupportedEncodingException {
		// 방법 1 (원래)
		// 쿠키 받기 - 요청 헤더의 쿠키 정보를 읽기
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = null;
				if(name.equals("mname")) {
					value = URLDecoder.decode(cookie.getValue(), "UTF-8");
				} else {
					value = cookie.getValue();
				}
				System.out.println(name + " : " + value);
			}
		}		
		return "exam06/index";	
	}
	
	@RequestMapping("/method4ReceiveCookieHow2")						
	public String method4ReceiveCookieHow2(@CookieValue(defaultValue="") String mid, @CookieValue(defaultValue="") String mname) {		// 넘어오는 파라미터와 매개변수의 변수명이 다를 경우 변수명을 지정해 준다. @CookieValue("mid")
		System.out.println("mid : " + mid);
		System.out.println("mname : " + mname);
		return "exam06/index";	
	}
	
	@RequestMapping("/method4DeleteCookie")						
	public String method4DeleteCookie(HttpServletResponse response) {				// 메모리뿐 아니라 하드디스크에 저장되어 있는 쿠키도 삭제
		Cookie cookie1 = new Cookie("mid", "");
		cookie1.setMaxAge(0);
		
		Cookie cookie2 = new Cookie("mname", "");
		cookie2.setMaxAge(0);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);		
		
		return "exam06/index";
	}
	
	@RequestMapping("/method5SetObject")
	public String method5SetObject(HttpSession session) {
		// 객체 생성
		Member member = new Member("fall", "한가을");
		
		// HttpSession 에 객체 저장
		session.setAttribute("member", member);	
		
		return "exam06/index";
	}
	
	@RequestMapping("/method5GetObject")
	public String method5GetObject(HttpSession session) {		
		// HttpSession 에 객체 얻기
		Member member = (Member) session.getAttribute("member");	 	// getAttribute 의 리턴타입이 Object 이므로 강제 타입변환
		if (member != null) {												// 생성을 하지 않고 실행 했을 때 NullPointerException 이 나기 때문에 
			System.out.println("mid : " + member.getMid());
			System.out.println("mname : " + member.getMname());
		}
		return "exam06/index";
	}
	
	@RequestMapping("/method5RemoveObject")
	public String method5RemoveObject(HttpSession session) {		
		// HttpSession 에 객체 삭제
		session.removeAttribute("member");
		return "exam06/index";	
	}
}
