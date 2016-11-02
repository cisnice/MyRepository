package com.mycompany.myboard.controller;

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

import com.mycompany.myboard.dto.MyPhotoBoard;
import com.mycompany.myboard.service.MyPhotoBoardService;

@Controller
@RequestMapping("/myphotoboard")
public class MyPhotoBoardController {
	
	@Autowired
	private MyPhotoBoardService myPhotoBoardService;
	
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
		
		int rowsPerPage=8;					
		int pagesPerGroup = 5;			
		
		int totalBoardNo = myPhotoBoardService.getCount();	
		
		int totalPageNo = totalBoardNo / rowsPerPage + ( (totalBoardNo % rowsPerPage != 0) ? 1 : 0 );
		int totalGroupNo = totalPageNo / pagesPerGroup + ( (totalPageNo % pagesPerGroup != 0) ? 1 : 0 );
		
		int groupNo = (intPageNo-1) / pagesPerGroup + 1;			
		int startPageNo = (groupNo-1) * pagesPerGroup + 1;			
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if ( groupNo == totalGroupNo ) {
			endPageNo = totalPageNo;
		}
		
		List<MyPhotoBoard> list = myPhotoBoardService.list(intPageNo, rowsPerPage);
		
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
		
		return "myphotoboard/list";
	}

	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "myphotoboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(MyPhotoBoard myPhotoBoard, HttpSession session) {		
		
		try {
			String mid = (String) session.getAttribute("login");							
			myPhotoBoard.setBwriter(mid);																
			
			myPhotoBoard.setOriginalfile(myPhotoBoard.getPhoto().getOriginalFilename());
			
			String savedfile = new Date().getTime() + myPhotoBoard.getPhoto().getOriginalFilename();	
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + savedfile);		
			myPhotoBoard.getPhoto().transferTo(new File(realpath));														
			myPhotoBoard.setSavedfile(savedfile);
			
			myPhotoBoard.setMimetype(myPhotoBoard.getPhoto().getContentType());
			
			int result = myPhotoBoardService.write(myPhotoBoard);			
			
			return "redirect:/myphotoboard/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "myphotoboard/write";
		}
	}
	
	@RequestMapping("/showPhoto")
	public void showPhoto(String savedfile, HttpServletRequest request, HttpServletResponse response) {
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
		MyPhotoBoard myPhotoBoard = myPhotoBoardService.info(bno);
		myPhotoBoard.setBhitcount(myPhotoBoard.getBhitcount() + 1);
		myPhotoBoardService.modify(myPhotoBoard);
		model.addAttribute("myphotoboard", myPhotoBoard);
		return "myphotoboard/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model) {
		MyPhotoBoard myPhotoBoard = myPhotoBoardService.info(bno);
		model.addAttribute("myphotoboard", myPhotoBoard);
		return "myphotoboard/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(MyPhotoBoard photoBoard, HttpSession session) {
		MyPhotoBoard dbPhotoBoard = myPhotoBoardService.info(photoBoard.getBno());
		photoBoard.setBhitcount(dbPhotoBoard.getBhitcount());
		
		try {
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename();		
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + savedfile);	
			photoBoard.getPhoto().transferTo(new File(realpath));													
			photoBoard.setSavedfile(savedfile);
			
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());
			
			int result = myPhotoBoardService.modify(photoBoard);			
			
			return "redirect:/myphotoboard/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "myphotoboard/modify";
		}
	}
	
	@RequestMapping("/remove")
	public String remove(int bno) {	
		myPhotoBoardService.remove(bno);
		return "redirect:/myphotoboard/list";
	}
}
