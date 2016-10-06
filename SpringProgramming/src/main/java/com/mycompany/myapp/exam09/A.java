package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A {
	private static final Logger logger = LoggerFactory.getLogger(A.class);
		
	public A() {
		logger.info("A객체 생성");		//servlet-context.xml 에서 객체로 생성
	}
	public void method() {
		logger.info("A.method() 실행");
	}
}
