package com.mycompany.myspring.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class H {
	private static final Logger logger = LoggerFactory.getLogger(H.class);
	
	public H() {
		logger.info("H 객체 생성");
	}
	
	public void method() {
		logger.info("H.method 실행");
	}
}
