package com.mycompany.myspring.exam11.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myspring.exam11.dto.Board;
import com.mycompany.myspring.exam11.dto.Member;
import com.mycompany.myspring.exam11.service.BoardService;
import com.mycompany.myspring.exam11.service.MemberService;

@Controller
@RequestMapping("/exam11")
public class Exam11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam11Controller.class);
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/index")	
	public String index() {
		logger.info("index 출력");
		return "exam11/index";
	}

	@RequestMapping(value = "/join", method=RequestMethod.GET )
	public String joinForm() {
		logger.info("join(GET) 출력");
		return "exam11/joinForm";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST )
	public String join(Member member) {
		logger.info("join(POST) 출력");
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
		
		memberService.join(member);
		
		return "redirect:/exam11/login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET )
	public String loginForm() {
		logger.info("loginForm(GET) 출력");
		return "exam11/loginForm";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST )
	public String login(String mid, String mpassword) {
		logger.info("login(POST) 출력");
		logger.info("mid : " + mid);
		logger.info("mpassword : " + mpassword);
		
		int result = memberService.login(mid, mpassword);
		if ( result == MemberService.LOGIN_SUCCESS ) {
			return "redirect:/exam11/index"; 
		} else if ( result == MemberService.LOGIN_FAIL_MID ) {
			return "redirect:/exam11/login";
		} else {
			return "redirect:/exam11/login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		logger.info("logout 출력");
		return "redirect:/exam11/index";
	}

	@RequestMapping(value = "/boardWrite", method=RequestMethod.GET )
	public String writeForm() {
		logger.info("writeForm(GET) 출력");
		return "exam11/writeForm";
	}
	
	@RequestMapping(value = "/boardWrite", method=RequestMethod.POST )
	public String write(Board board) {
		logger.info("write(POST) 출력");
		boardService.write(board);
		return "redirect:/exam11/index";
	}
	
	@RequestMapping("/boardList" )
	public String list(Model model) {
		logger.info("list 출력");
		List<Board> list = boardService.getList();
		model.addAttribute("boardList", list);
		return "exam11/boardList";
	}
	
	@RequestMapping("/boardView" )
	public String view(int bno, Model model) {
		logger.info("view 출력");
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "exam11/boardView";
	}
	
	@RequestMapping(value = "/boardUpdate", method=RequestMethod.GET )
	public String boardUpdateForm(int bno, Model model) {
		logger.info("boardUpdateForm(GET) 출력");
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);		
		return "exam11/boardUpdateForm";
	}
	
	@RequestMapping(value = "/boardUpdate", method=RequestMethod.POST )
	public String boardUpdate(Board board) {
		logger.info("boardUpdate(POST) 출력");
		boardService.updateBoard(board);
		return "redirect:/exam11/boardList";
	}
	
	@RequestMapping("/boardDelete" )
	public String delete(int bno) {
		logger.info("delete 출력");
		boardService.deleteBoard(bno);		
		return "redirect:/exam11/boardList";
	}
}
