package com.mycompany.myspring.exam07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam07")
public class Exam07Controller {
	
	@RequestMapping("/index")
	public String index() {		
		return "exam07/index";
	}
	
	

}
