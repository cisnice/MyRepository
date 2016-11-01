package com.mycompany.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myboard.service.MyBoardMemberService;

@Controller
@RequestMapping("/myboardmember")
public class MyBoardMemberController {

	@Autowired
	MyBoardMemberService myBoardMemberService;
	
	@RequestMapping(value="/myboard_login", method=RequestMethod.GET)
	public String loginForm() {
		return "myboardmember/myboard_loginForm";
	}
	
	@RequestMapping(value="/myboard_login", method=RequestMethod.POST)
	public String login(String mid) {
		int result = myBoardMemberService.login(mid);
		if (result == MyBoardMemberService.LOGIN_FAIL_MID) {
			return "myboardmember/myboard_loginForm";
		}
		return "redirect:/";
	}
	
}
