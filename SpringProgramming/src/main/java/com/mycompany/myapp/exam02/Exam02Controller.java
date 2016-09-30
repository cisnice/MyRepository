package com.mycompany.myapp.exam02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exam02")		//모든 @ 는 value 가 생략된다. @RequestMapping(value="/exam02")
public class Exam02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);
	
	@RequestMapping("/index")
	public String index() {
		logger.info("index 요청 처리");
		return "exam02/index";
	}	
	
//	@RequestMapping("/join")
//	public String join(String mid, String mname, String mage) {		//index.jsp 에서 보낸 파라미터를 받는다.
//		logger.info("join 요청 처리");
//		logger.info("mid : " + mid);
//		logger.info("mname : " + mname);
//		logger.info("mage : " + mage);
//		return "exam02/index";
//	}
	
	@RequestMapping("/join")
	public String join(Member member) {		
		logger.info("join 요청 처리");
		logger.info("mid : " + member.getMid());
		logger.info("mname : " + member.getMname());
		logger.info("mage : " + member.getMage());
		return "exam02/index";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam("id") String mid,			 					//index.jsp 에서 넘어온 파라미터와 받는 매개변수가 다르다면 @RequestParam 을 넣어준다.
			@RequestParam("password") String mpassword) {		// @RequestParam(value = "password") => value 생략
		logger.info("login 요청 처리");
		logger.info("mid : " + mid);
		logger.info("mpassword : " + mpassword);		
		return "exam02/index";
	}
	
	@RequestMapping("/order")
	public String order(String pid, String pname, int pprice, String pcompany) {	//String 으로 넘어오지만 int로 선언해도 Spring에서 String으로 자동 변환한다. 	
		logger.info("order 요청 처리");
		logger.info("pid : " + pid);
		logger.info("pname : " + pname);
		logger.info("pprice : " + pprice);
		logger.info("pcompany : " + pcompany);
		return "exam02/index";
	}
	
	@RequestMapping("/write")
	public String write(
			@RequestParam(defaultValue="1" ) int bno, 
			String title, String content, 
			@RequestParam(defaultValue="0" ) int hitcount) {	 	
		logger.info("write 요청 처리");
		logger.info("bno : " + bno);					// index.jsp에서 넘어온 파라미터가 없을 경우 매개변수가 String이면 null 이 되는데  
		logger.info("title : " + title);					// int로 받을경우 IllegalStateException 발생
		logger.info("content : " + content);			// defaultValue 값 지정해서 int에 넣어준다.
		logger.info("hitcount : " + hitcount);		// 파라미터가 있으면 파라미터값, 없으면 defaultValue
		return "exam02/index";
	}
	
	@RequestMapping("/update")
	public String update(
			@RequestParam(defaultValue="1") int bno, 
			String title, String content, 
			@RequestParam(value="count", defaultValue="0" ) int hitcount) {	 	
		logger.info("update 요청 처리");
		logger.info("bno : " + bno);					  
		logger.info("title : " + title);					
		logger.info("content : " + content);			
		logger.info("hitcount : " + hitcount);		
		return "exam02/index";
	}
	
	@RequestMapping("/send")
	public String send(Board board) {	 	
		logger.info("send 요청 처리");
		logger.info("bno : " + board.getBno());					  
		logger.info("title : " + board.getTitle());					
		logger.info("content : " + board.getContent());			
		logger.info("hitcount : " + board.getHitcount());		
		return "exam02/index";
	}
}
