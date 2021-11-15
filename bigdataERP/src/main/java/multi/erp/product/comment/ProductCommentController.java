package multi.erp.product.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductCommentController {
	@Autowired
	ProductCommentService service;
		//ajax처리X
	@RequestMapping(value = "/comment/write.do", method = RequestMethod.POST)
	public String insertComment(ProductCommentVO article) {
		System.out.println(article);
		service.writeComment(article);
		return "redirect:/product/read.do?prd_no="+article.getPrd_no();
	}
	@RequestMapping(value = "/comment/result.do", method = RequestMethod.GET)
	public ModelAndView showCommentResult() {
		ModelAndView mav = new ModelAndView();
		List<CommentResultVO> resultList = service.commentResult();
		List<CommentResultVO>  tableList = new ArrayList<CommentResultVO> ();
		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			CommentResultVO result =  resultList.get(i);
			tableList.add(result);
			if(i==10){
				break;
			}
		}
		mav.addObject("resultList",resultList);
		mav.addObject("tableList",tableList);
		mav.setViewName("comment/result");
		return mav;
	}

}








