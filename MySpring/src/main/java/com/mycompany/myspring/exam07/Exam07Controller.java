package com.mycompany.myspring.exam07;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam07")
public class Exam07Controller {
	
	@RequestMapping("/index")
	public String index() {		
		return "exam07/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request) {	
		request.setAttribute("AAA", "aaa");
		request.setAttribute("BBB", "bbb");
		return "exam07/usedata";
	}
	
	@RequestMapping("/method2")
	public String method2(HttpSession session) {	
		session.setAttribute("CCC", "ccc");
		session.setAttribute("DDD", "ddd");		
		return "exam07/usedata";
	}

	@RequestMapping("/method3")
	public String method3(Model model) {	
		model.addAttribute("EEE", "eee");
		model.addAttribute("FFF", "fff");		
		return "exam07/usedata";
	}
	
	@RequestMapping("/method4")
	public String method4(Model model) {
		Board board = new Board();
		board.setBno(1);
		board.setTitle("이것이 자바다");
		board.setContent("자바");
		board.setHitcount(1);
		model.addAttribute("board", board);
		return "exam07/usedata";
	}
	
	@RequestMapping("/method5")
	public String method5(Model model) {
		List<Board> list = new ArrayList<>();
		
		for(int i=1; i<=5; i++){
			Board board = new Board();
			board.setBno(i);
			board.setTitle("제목" + i);
			board.setContent("내용" + i);
			board.setHitcount(1);
			list.add(board);
		}		
		
		model.addAttribute("boardList", list);
		return "exam07/usedata";
	}
}
