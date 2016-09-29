package com.mycompany.myspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping("join")
	public String join() {		
		logger.info("join");		
		return "member/join";
	}
	
	@RequestMapping("login")
	public String login() {		
		logger.info("login");		
		return "member/login";
	}
	
	@RequestMapping("logout")
	public String logout() {		
		logger.info("logout");		
		return "member/logout";
	}
	
	@RequestMapping("withdraw")
	public String withdraw() {		
		logger.info("withdraw");		
		return "member/withdraw";
	}
	
}
