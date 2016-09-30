package com.mycompany.myspring.exam04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);
	
	@RequestMapping("/index")
	public String index() {
		logger.info("index()");		
		return "exam04/index";
	}
	
	@RequestMapping(value="/enroll", method=RequestMethod.GET)
	public String enrollForm() {
		logger.info("enrollForm() 출력");
		return "exam04/enrollForm";
	}
	
	@RequestMapping(value="/enroll", method=RequestMethod.POST)
	public String enroll(String title, String content) {
		logger.info("enroll() 출력");
		logger.info("title : " + title);
		logger.info("content : " + content);
		return "exam04/index";
	}	
}
