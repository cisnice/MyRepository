package com.mycompany.myspring.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class B {
	private static final Logger logger = LoggerFactory.getLogger(B.class);
	
	private C c;
	
	public B(C c) {
		logger.info("B객체 생성");	
		this.c = c;
	}
	public void method() {
		logger.info("B.method() 실행");
		c.method();
	}
}
