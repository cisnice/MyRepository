package com.mycompany.myweb.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Light;
import com.mycompany.myweb.dto.Restaurant;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")							
	public String index() {
		logger.info("index() 실행");					
		return "index";  										
	}
	
	@RequestMapping("/lightList")
	public String lightList(Model model) {
		   List<Light> list = new ArrayList<>();
	       list.add(new Light("light1.png", "light1_large.png", "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light2.png", "light2_large.png", "인테리어 조명2", "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light3.png", "light3_large.png", "인테리어 조명3", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light4.png", "light4_large.png", "인테리어 조명4", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light5.png", "light5_large.png", "인테리어 조명5", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light1.png", "light1_large.png", "인테리어 조명6", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light2.png", "light2_large.png", "인테리어 조명7", "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light3.png", "light3_large.png", "인테리어 조명8", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light4.png", "light4_large.png", "인테리어 조명9", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       list.add(new Light("light5.png", "light5_large.png", "인테리어 조명10", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
	       
	       model.addAttribute("list", list);
	       return "lightList";
	}
	
	@RequestMapping("/restaurantList")
	public String restaurantList(Model model) {
		   List<Restaurant> list = new ArrayList<>();
	       list.add(new Restaurant("food01.png", "food01_large.png", "인테리어 조명1", "35,000 Won", "Information"));
	       list.add(new Restaurant("food02.png", "food02_large.png", "인테리어 조명2", "15,000 Won", "about"));
	       list.add(new Restaurant("food03.png", "food03_large.png", "인테리어 조명3", "25,000 Won", "popular"));
	       list.add(new Restaurant("food04.png", "food04_large.png", "인테리어 조명4", "30,000 Won", "Korean food dishes"));
	       list.add(new Restaurant("food05.png", "food05_large.png", "인테리어 조명5", "60,000 Won", "local restaurant listias in the Tri-state area."));
	       list.add(new Restaurant("food01.png", "food01_large.png", "인테리어 조명6", "35,000 Won", "Information"));
	       list.add(new Restaurant("food02.png", "food02_large.png", "인테리어 조명7", "15,000 Won", "about"));
	       list.add(new Restaurant("food03.png", "food03_large.png", "인테리어 조명8", "25,000 Won", "popular"));
	       list.add(new Restaurant("food04.png", "food04_large.png", "인테리어 조명9", "30,000 Won", "Korean food dishes"));
	       list.add(new Restaurant("food05.png", "food05_large.png", "인테리어 조명10", "60,000 Won", "local restaurant listias in the Tri-state area."));
	       
	       model.addAttribute("list", list);
	       return "restaurantList";
	}
	
	@RequestMapping("/getImage")
	public void getImage(String fileName, HttpServletRequest request, HttpServletResponse response) {
		
		try {						
			String mimeType = request.getServletContext().getMimeType(fileName);			
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();			
			String filePath = request.getServletContext().getRealPath("/resources/image/" + fileName);
			InputStream is = new FileInputStream(filePath);
			
			byte[] values = new byte[1024];
			int byteNum = -1;
			while( (byteNum = is.read(values)) !=-1 ) {
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
