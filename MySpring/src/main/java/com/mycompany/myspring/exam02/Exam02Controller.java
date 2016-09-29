package com.mycompany.myspring.exam02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);
	
	@RequestMapping("/index")
	public String index() {
		logger.info("index()");		
		return "exam02/index";
	}
	
	@RequestMapping("/join")
	public String join(String mid, String mname, 
							@RequestParam(defaultValue="1") int mage) {
		logger.info("join()");
		logger.info("mid : " + mid);
		logger.info("mname : " + mname);
		logger.info("mage : " + mage);
		return "exam02/index";
	}
	
	@RequestMapping("/login")
	public String login( @RequestParam(value="id") String mid, 
								@RequestParam(value="password")  String mpassword) {
		logger.info("login()");
		logger.info("mid : " + mid);
		logger.info("mpassword : " + mpassword);		
		return "exam02/index";
	}
	
	@RequestMapping("/order")
	public String order(Product product) {
		logger.info("order()");
		logger.info("pid : " + product.getPid());
		logger.info("pname : " + product.getPname());
		logger.info("pprice : " + product.getPprice());
		logger.info("pcompany : " + product.getPcompany());
		return "exam02/index";
	}
}
