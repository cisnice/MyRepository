package com.mycompany.myapp.exam04;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam03.Member;

@Controller
public class Exam04Controller {

	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);
	
	@RequestMapping("/exam04/index")
	public String index() {		
		logger.info("index 요청처리");
		return "exam04/index";		
	}
	
	@RequestMapping(value="/exam04/join", method=RequestMethod.GET)		// value 값이 충돌되지만 요청방식을 지정해서 충돌나지 않게 함.  간단한 데이터 전송 OK					                     
	public String joinForm() {																			// 전송 용량 제한있음. 문자만 전송. url + 데이터를 시작행에 실어 보낸다. 
		logger.info("joinForm 요청처리");															// 시작행의 길이가 제한되어 있어 길어지면 잘려서 전송된다. 
		return "exam04/joinForm";																			
	}
	
	@RequestMapping(value="/exam04/join", method=RequestMethod.POST)		// 시작행에 경로만 들어가고, 데이터는 본문에 들어감. mid=xxx&mname=yyy	
	public String join(Member member) {														// 전송 용량 제한 없음. 몇 기가도 보낼 수 있다. 
		logger.info("join 요청처리");																	// 데이터가 본문에 들어가서 url에 포함되지 않아 보안상 유리하다.
																												// POST 방식은 따로 디코딩을 해줘야 한글이 깨지지 않는다.
//		String name = member.getMname();														// 일일이 컨트롤러에서 디코딩할 수 없으니 web.xml 에서
//		try {																									// CharacterEncodingFilter 를 설정해서 컨트롤러에 도착하기 전에 디코딩해서 넘겨준다.
//			name = new String(name.getBytes("8859_1"), "UTF-8");
//		} catch (UnsupportedEncodingException e) {}
		
		logger.info("mid : " + member.getMid());
		logger.info("mname : " + member.getMname());
		logger.info("mpassword : " + member.getMpassword());
		logger.info("memail : " + member.getMemail());
		logger.info("mtel : " + member.getMtel());
		logger.info("mjob : " + member.getMjob());
		logger.info("mskill : " + Arrays.toString(member.getMskill()));
		logger.info("maddress1 : " + member.getMaddress1());
		logger.info("maddress2 : " + member.getMaddress2());
		logger.info("mbirth : " + member.getMbirth());
		return "exam04/index";		
	}
	
	@RequestMapping(value="/exam04//write", method=RequestMethod.GET)
	public String writeForm() {
		logger.info("writeForm 요청처리");
		return "exam04/writeForm";
	}
	
	@RequestMapping(value="/exam04//write", method=RequestMethod.POST)
	public String write(String btitle, String bcontent) {
		logger.info("write 요청처리");
		logger.info("btitle : " + btitle);
		logger.info("bcontent : " + bcontent);
		return "exam04/index";
	}
	
}
