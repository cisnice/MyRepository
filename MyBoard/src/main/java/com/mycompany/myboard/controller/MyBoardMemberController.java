package com.mycompany.myboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myboard.dto.MyBoardMember;
import com.mycompany.myboard.service.MyBoardMemberService;

@Controller
@RequestMapping("/myboardmember")
public class MyBoardMemberController {

	@Autowired
	MyBoardMemberService myBoardMemberService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "myboardmember/myboard_loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String mid, String mpassword, HttpSession session, Model model) {
		int result = myBoardMemberService.login(mid, mpassword);
		if(result == myBoardMemberService.LOGIN_FAIL_MPASSWORD) {
			model.addAttribute("error", "LOGIN_FAIL_MPASSWORD");
			return "myboardmember/myboard_loginForm";
		} else if(result == myBoardMemberService.LOGIN_FAIL_MID) {
			model.addAttribute("error", "LOGIN_FAIL_MID");
			return "myboardmember/myboard_loginForm";
		} else {
			session.setAttribute("login", mid);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.GET)
	public String findMidForm() {
		return "myboardmember/myboard_findMidForm";
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.POST)
	public String findMid(String memail, Model model, HttpSession session) {
		String mid = myBoardMemberService.findMid(memail);
		if(mid == null) {
			model.addAttribute("error", "이메일이 존재하지 않음");
			return "myboardmember/myboard_findMidForm";
		}
		session.setAttribute("findMid", mid);
		return "redirect:/myboardmember/login";		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "myboardmember/myboard_joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MyBoardMember member) {
		try {															// 예외처리는 Controller에서. service나 dao에서는 하면 안된다.
			int result = myBoardMemberService.join(member);			
			return "redirect:/myboardmember/login";
		} catch(Exception e) {
			return "myboardmember/myboard_joinForm";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		String mid = (String) session.getAttribute("login");
		int result = myBoardMemberService.logout(mid);
		if(result == myBoardMemberService.LOGOUT_SUCCESS) {
			session.removeAttribute("login");
		}		
		return "redirect:/";
	}
	
	@RequestMapping("/info")
	public String info(String mpassword, HttpSession session, Model model) {
		String mid = (String) session.getAttribute("login");		
		MyBoardMember member = myBoardMemberService.info(mid, mpassword);
		model.addAttribute("member", member);
		return "myboardmember/info";
	}
	
}
