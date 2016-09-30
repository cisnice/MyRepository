package com.mycompany.myspring.exam03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam03Controller.class);
	
	@RequestMapping("/index")
	public String index() {
		logger.info("index()");		
		return "exam03/index";
	}
	
	@RequestMapping("/enroll")
	public String enroll() {
		logger.info("enroll()");		
		return "exam03/index";
	}
}
