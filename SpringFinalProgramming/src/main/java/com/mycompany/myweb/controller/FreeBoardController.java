package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.service.FreeBoardService;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue="1") int pageNo, Model model) {
		int rowsPerPage=10;				// 한 페이지에 보여지는 열의 수
		int pagesPerGroup = 5;			// 그룹 당 페이지 수
		
		int totalBoardNo = freeBoardService.getCount();			// 전체 게시물의 수
		
		int totalPageNo = totalBoardNo / rowsPerPage + ( (totalBoardNo % rowsPerPage != 0) ? 1 : 0 );
		int totalGroupNo = totalPageNo / pagesPerGroup + ( (totalPageNo % pagesPerGroup != 0) ? 1 : 0 );
		
		int groupNo = (pageNo-1) / pagesPerGroup + 1;				// (3-1)/5+1=1   Group1, (14-1)/5+1=3  Group3
		int startPageNo = (groupNo-1) * pagesPerGroup + 1;			// (1-1)*5+1=1, (2-1)*5+1=6
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if ( groupNo == totalGroupNo ) {
			endPageNo = totalPageNo;
		}
		
		List<FreeBoard> list = freeBoardService.list(pageNo, rowsPerPage);
		
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);		
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);	
		
		return "freeboard/list";
	}

	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "freeboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(FreeBoard freeBoard, HttpSession session) {
		String mid = (String) session.getAttribute("login");
		freeBoard.setBwriter(mid);
		int result = freeBoardService.write(freeBoard);
		if ( result == FreeBoardService.WRITE_FAIL ) {
			return "freeboard/write";
		}
		return "redirect:/freeboard/list";
	}
	
	@RequestMapping("/info")
	public String info(int bno, Model model) {
		FreeBoard freeBoard = freeBoardService.info(bno);
		freeBoard.setBhitcount(freeBoard.getBhitcount()+1);
		freeBoardService.modify(freeBoard);
		model.addAttribute("freeboard", freeBoard);
		return "freeboard/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model) {
		FreeBoard freeBoard = freeBoardService.info(bno);
		model.addAttribute("freeboard", freeBoard);
		return "freeboard/modify";
	}

	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(FreeBoard freeBoard) {
		FreeBoard dbFreeBoard = freeBoardService.info(freeBoard.getBno());
		freeBoard.setBhitcount(dbFreeBoard.getBhitcount());
		freeBoardService.modify(freeBoard);
		return "redirect:/freeboard/list";
	}
}
