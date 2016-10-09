package com.mycompany.myspring.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class E {
	private static final Logger logger = LoggerFactory.getLogger(E.class);
	
	private F f;
	
	@Autowired
	public E(F f) {
		logger.info("E객체 생성");
		this.f = f;
	}
	
	public void method() {
		logger.info("E.method 실행");
		f.method();
	}
}
