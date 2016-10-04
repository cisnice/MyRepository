package com.mycompany.myapp.exam05;

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
		logger.info("index 요청처리");
		return "exam05/index";		
	}
	
	@RequestMapping("/exam05/index2")
	public ModelAndView index2() {		
		logger.info("index2 요청처리");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam05/index");	// views 이하의 경로
		return mav;		
	}
	
	@RequestMapping("/exam05/index3")																									//return 값이 없으면 제일 마지막 값인 index3 의 jsp 를 찾는다.
	public void index3(HttpServletRequest request , HttpServletResponse response) throws IOException {			//자체적으로 응답(response) 보낼 메시지가 있으면  jsp 를 찾지 않는다.
		logger.info("index3 요청처리");
		response.setContentType("image/jpeg");
		
//		InputStream is = new FileInputStream("D:/Kosa3sw/MyRepository/SpringProgramming/src/main/webapp/WEB-INF/image/photo1.jpg");	 // 편의상 절대 경로 지정 
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg");		// 절대경로를 지정하면 안되기때문에 상대경로 지정
		InputStream is = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while( (byteNum = is.read(values)) != -1) {
			os.write(values, 0, byteNum);			
		}
		os.flush();
		is.close();	// os 는 톰캣에서 close 해준다. close 안해도 된다.		
	}	
}
