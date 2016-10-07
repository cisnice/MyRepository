package com.mycompany.myspring.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterAImpl1 implements InterA {
	private static final Logger logger = LoggerFactory.getLogger(InterAImpl1.class);
	
	public InterAImpl1() {
		logger.info("InterAImpl1 객체 생성");
	}
	
	@Override
	public void method() {	
		logger.info("InterAImpl1.method() 실행");
	}
}
