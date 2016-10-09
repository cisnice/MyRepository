package com.mycompany.myspring.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class F {
	private static final Logger logger = LoggerFactory.getLogger(F.class);
	
	public F() {
		logger.info("F객체 생성");
	}
	
	public void method() {
		logger.info("F.method 실행");
	}
}
