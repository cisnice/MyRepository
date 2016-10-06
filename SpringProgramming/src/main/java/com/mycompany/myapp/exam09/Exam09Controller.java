package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		//Controller가 없어도 servlet-context.xml 에서 관리 객체로 생성했기 때문에 동작에 문제 없다. 둘다 선언되면 하나만 만들어서 공유한다.
@RequestMapping("/exam09")
public class Exam09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);
	
	private A a;	
	public void setA(A a) {
		logger.info("setA() 실행");		// servlet-context.xml 에서 setter 주입으로 실행됨
		this.a=a;
	}
	
	private B b;	
	public void setB(B b) {
		logger.info("setB() 실행");
		this.b=b;
	}
	
	private ServiceA serviceA;
	public void setServiceA(ServiceA serviceA) {
		logger.info("setServiceA() 실행");
		this.serviceA = serviceA;
	}
	
	private ServiceB serviceB;
	public void setServiceB(ServiceB serviceB) {
		logger.info("setServiceB() 실행");
		this.serviceB = serviceB;
	}
	
	private ServiceC serviceC;
	public void setServiceC(ServiceC serviceC) {
		logger.info("setServiceC() 실행");
		this.serviceC = serviceC;
	}
	
	private ServiceD serviceD;
	public void setServiceD(ServiceD serviceD) {
		logger.info("setServiceD() 실행");
		this.serviceD = serviceD;
	}

	public Exam09Controller() {
		logger.info("Exam09Controller 객체 생성");
	}
	
	@RequestMapping("/index")
	public String index() {
		logger.info("index() 처리");
		return "exam09/index";
	}

	@RequestMapping("/method1")
	public String method1() {
		logger.info("method1() 처리");
		a.method();
		b.method();
		serviceA.method();
		serviceB.method();
		serviceC.method();
		serviceD.method();
		return "redirect:/exam09/index";
	}
}
