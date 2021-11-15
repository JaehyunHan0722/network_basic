package multi.erp.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import multi.erp.product.comment.ProductCommentService;
import multi.erp.product.comment.ProductCommentVO;
@Controller
public class ProductController {
	@Autowired
	ProductService service;
	@Autowired
	ProductCommentService commentservice;

	
	@RequestMapping("/product/index.do")
	public ModelAndView main(){
		System.out.println("어노테이션 기반");
		List<ProductVO> hitProduct = service.hitproduct();
		List<ProductVO> newProduct = service.newproduct();
		ModelAndView mav = new ModelAndView();
		mav.addObject("hitProduct", hitProduct);
		mav.addObject("newProduct", newProduct);
		System.out.println(hitProduct);
		System.out.println(newProduct);
		mav.setViewName("product/index");
		return mav;
	}
	//전체상품보기,카테고리별 보기
	@RequestMapping("/product/list.do")
	public ModelAndView list(String category){
		System.out.println("category=>"+category);
		ModelAndView mav = new ModelAndView();
		List<ProductVO> list = service.productlist(category);
		mav.addObject("prdlist", list);//db에서 조회한 결과 
		                               //- 서블릿에서 request.setAttribute
		mav.setViewName("product/list");
		return mav;
	}
	//상품상세보기
	@RequestMapping("/product/read.do")
	public ModelAndView showProduct(String prd_no,String category) {
		ModelAndView mav = new ModelAndView("product/read");
		List<ProductCommentVO> commentlist	= commentservice.commentlist(prd_no);
		ProductVO product = service.read(prd_no);
		mav.addObject("product", product);
		mav.addObject("commentlist", commentlist);

		return mav ;
	}
	//일반 메소드 리턴하는 것처럼 List<BoardDTO>를 리턴하면서
	//@ResponseBody로 설정하면 jackson라이브러리가 자동으로 json객체로 변환
	@RequestMapping(value = "/product/show_json",
			method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody List<ProductVO> categoryboardlist(
									String category) {
		String result = "";
		List<ProductVO> prdlist = service.productlist(category);
		System.out.println("ajax통신"+prdlist);
		return prdlist;
	}
}









