package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import multi.erp.board.BoardService;
import multi.erp.board.BoardVO;

@Controller
public class IndexController {
	@Autowired
	BoardService service;
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		//index뷰에서 게시판 카테고리의 목록을 조회해야 하므로
		List<BoardVO> boardlist = service.findByCategory("게시판");
		mav.addObject("boardlist", boardlist);
		return mav;
	}
//	@RequestMapping("/emp/login.do")
//	public String loginPage() {
//		return "login";
//	}
	@RequestMapping("/menu/board.do")
	public String boardlist() {//db연동
		return "board/list";
	}
	@RequestMapping("/admin/index.do")
	public String adminMain(){
		System.out.println("어노테이션 기반");
		return "admin/index";
	}
}
