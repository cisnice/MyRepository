package com.mycompany.myspring.exam05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Exam05Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam05Controller.class);
	
	@RequestMapping("/exam05/index")
	public String index() {
		logger.info("index 실행");
		return "exam05/index";
	}
	
	@RequestMapping("/exam05/index2")
	public ModelAndView index2() {
		logger.info("index2 실행");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam05/index");
		return mav;
	}
	
	@RequestMapping("/exam05/index3")
	public void index3(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("index3 실행");
		response.setContentType("image/jpg");
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg");
		InputStream is = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while( (byteNum = is.read(values)) != -1) {
			os.write(values, 0, byteNum);			
		}
		os.flush();
		is.close();
		os.close();		
	}
}
