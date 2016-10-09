package com.mycompany.myspring.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C {
	private static final Logger logger = LoggerFactory.getLogger(C.class);
		
	public C() {
		logger.info("C객체 생성");		
	}
	public void method() {
		logger.info("C.method() 실행");
	}
}
