package com.mycompany.myspring.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class D {
	private static final Logger logger = LoggerFactory.getLogger(D.class);
	
	public D() {
		logger.info("D객체 생성");
	}
	
	public void method() {
		logger.info("D.method 실행");
	}
}
