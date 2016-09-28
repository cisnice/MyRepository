package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")							// URL 주소 지정 시 구분자 사용. http://localhost:8080/myapp/
	public String home() {								// 메소드 명은 어떤 것을 써도 상관없다.
		System.out.println("home() 실행1");		// 테스트 용도로 작성하지만 나중에 개발 끝난 후에 다 지워야 하기 때문에 쓰지 않는다.
		logger.info("home() 실행2");					// Log 레벨을 지정해서 출력이 될지 안될지 정한다. trace, debug, info, warn, error, off
		return "home";  									// *.jsp 파일명과 같아야 한다.	
	}
	
	@RequestMapping("/news")						// http://localhost:8080/myapp/news	
	public String news() {
		logger.info("news() 실행");
		return "news";
	}
	
}
