package com.mycompany.myweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.myweb.service.PhotoBoardService;

@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {
	
	@Autowired
	private PhotoBoardService photoBoardService;
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session) {

		int intPageNo = 1;
		if ( pageNo == null ) {
			pageNo = (String) session.getAttribute("pageNo");
			if ( pageNo != null ) {
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage=8;					 // 한 페이지에 보여지는 열의 수
		int pagesPerGroup = 5;			// 그룹 당 페이지 수
		
		int totalBoardNo = photoBoardService.getCount();			// 전체 게시물의 수
		
		int totalPageNo = totalBoardNo / rowsPerPage + ( (totalBoardNo % rowsPerPage != 0) ? 1 : 0 );
		int totalGroupNo = totalPageNo / pagesPerGroup + ( (totalPageNo % pagesPerGroup != 0) ? 1 : 0 );
		
		int groupNo = (intPageNo-1) / pagesPerGroup + 1;				// (3-1)/5+1=1   Group1, (14-1)/5+1=3  Group3
		int startPageNo = (groupNo-1) * pagesPerGroup + 1;			// (1-1)*5+1=1, (2-1)*5+1=6
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if ( groupNo == totalGroupNo ) {
			endPageNo = totalPageNo;
		}
		
		List<PhotoBoard> list = photoBoardService.list(intPageNo, rowsPerPage);
		
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);		
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);	
		
		return "photoboard/list";
	}

	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "photoboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PhotoBoard photoBoard, HttpSession session) {			// multipart/form-data 를 해석할수 있는 기능이 spring 에 없다. 때문에 라이브러리를 추가해야한다.
		
		try {
			String mid = (String) session.getAttribute("login");								// pom.xml 에 File Upload를 위한 라이브러리 추가.  servlet-context.xml 에 Multipart/form-data 해석을 위한 스프링 관리 객체 설정
			photoBoard.setBwriter(mid);																// 라이브러리 - http://search.maven.org/ 에서 fileupload 검색. commons-fileupload 선택. dependency 복사 pom.xml 에 추가	
			
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			
			String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename();		// 저장되는 파일 이름이 유일해야 하기 때문에 시간+파일이름으로 저장한다.
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + savedfile);		// 사진이 저장된 절대 경로
			photoBoard.getPhoto().transferTo(new File(realpath));														// 클라이언트에서 보내준 파일을 realpath에 저장한다.
			photoBoard.setSavedfile(savedfile);
			
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());
			
			int result = photoBoardService.write(photoBoard);			
			
			return "redirect:/photoboard/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "photoboard/write";
		}
	}
	
	@RequestMapping("/showPhoto")
	public void showPhoto(String savedfile, HttpServletRequest request, HttpServletResponse response) {
		/*
		// 브라우저에서 보여주지 않고 강제로 다운로드할 경우		
		String fileName = savedfile;
		fileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");		
		*/
		
		try {
			String fileName = savedfile;
			
			String mimeType = request.getServletContext().getMimeType(fileName);			
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/" + fileName);
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
	
	@RequestMapping("/info")
	public String info(int bno, Model model) {
		PhotoBoard photoBoard = photoBoardService.info(bno);
		photoBoard.setBhitcount(photoBoard.getBhitcount() + 1);
		photoBoardService.modify(photoBoard);
		model.addAttribute("photoBoard", photoBoard);
		return "photoboard/info";
	}
}
