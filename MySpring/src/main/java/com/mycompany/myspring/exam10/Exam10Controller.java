package com.mycompany.myspring.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam10Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam10Controller.class);
	
	@Autowired
	private D d;	
	public void setD(D d) {
		this.d = d;
	}
	
	@Autowired
	private E e;
	public void setE(E e) {
		this.e = e;
	}
	
	@Autowired
	private G g;
	
	@RequestMapping("/exam10/index")
	public String index() {
		logger.info("index() 실행");
		return "exam10/index";
	}
	
	@RequestMapping("/exam10/method1")
	public String method1() {
		logger.info("method1() 실행");
		d.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/exam10/method2")
	public String method2() {
		logger.info("method2() 실행");
		e.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/exam10/method3")
	public String method3() {
		logger.info("method3() 실행");
		g.method();
		return "redirect:/exam10/index";
	}
	
}
