package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C {
	private static final Logger logger = LoggerFactory.getLogger(C.class);
	
	private D d; 
	
	public C(D d) {						// 생성자 주입
		logger.info("C객체 생성");
		this.d = d;
	}
	
	public void method() {
		logger.info("C.method() 실행");
		d.method();
	}
}
