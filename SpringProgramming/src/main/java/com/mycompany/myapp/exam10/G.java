package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component			// scan 할때 @Component 붙은 것은 전부 기본생성자로 관리객체 생성
public class G {
	private static final Logger logger = LoggerFactory.getLogger(G.class);
	
	public G() {
		logger.info("G객체 생성");
	}

	public void method() {
		logger.info("G.method 생성");
	}
}
