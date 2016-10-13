package com.mycompany.myapp.exam10;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam10")
public class Exam10Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam10Controller.class);
	
	private G g;	
	@Autowired					// 자동으로 연결 시킨다. setter에서 관리객체인 G객체를 자동으로 연결
	public void setG(G g) {
		logger.info("setG() 실행");
		this.g = g;
	}

	private H h;
	@Autowired
	public void setH(H h) {
		logger.info("setH() 실행");
		this.h = h;
	}
	
	private Service service;
//	@Autowired											// Type으로 주입. 인터페이스를 구현한 관리객체가 1개 일 때 사용. setter, 필드 주입 가능 
	@Resource(name="serviceImpl2")				// 등록 이름으로 주입. 인터페이스를 구현한 관리객체가 2개 이상일 때 사용. 첫자 소문자, setter 주입만 가능
	public void setService(Service service) {		// Service 인터페이스를 구현한 관리객체(@Component)가 대입된다.  	
		logger.info("setService() 실행");				
		this.service = service;
	}
	
	private I i;
	@Autowired
	public void setI(I i) {
		logger.info("setI() 실행");
		this.i = i;
	}
	
	private J j;
	@Autowired
	public void setJ(J j) {
		logger.info("setJ() 실행");
		this.j = j;
	}
	
	@Autowired
	private K k;
	
	@RequestMapping("/index")
	public String index() {
		logger.info("index() 처리");
		return "exam10/index";
	}

	@RequestMapping("/method1")
	public String method1() {
		logger.info("method1() 처리");
		g.method();
		h.method();
		service.method();		
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/method2")
	public String method2() {
		logger.info("method2() 처리");
		i.method();			
		j.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/method3")
	public String method3() {
		logger.info("method3() 처리");
		k.method();		
		return "redirect:/exam10/index";
	}
}
