package com.mycompany.myspring.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09")
public class Exam09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);
	
	private A a;	
	public void setA(A a) {
		logger.info("setA() 실행");		
		this.a=a;
	}
	
	private InterA interA;
	public void setInterA(InterA interA) {
		logger.info("setInterA() 실행");		
		this.interA=interA;
	}
	
	private B b;
	public void setB(B b) {
		logger.info("setB() 실행");
		this.b = b;
	}

	@RequestMapping("/index")
	public String index() {		
		return "exam09/index";
	}
	
	@RequestMapping("/method1")
	public String method1() {
		logger.info("method1() 처리");
		a.method();	
		interA.method();
		return "redirect:/exam09/index";
	}
	
	@RequestMapping("/method2")
	public String method2() {
		logger.info("method2() 처리");
		b.method();		
		return "redirect:/exam09/index";
	}
}
