package multi.erp.product.comment;

import java.util.List;

public interface ProductCommentService {
	void writeComment(ProductCommentVO article);
	List<ProductCommentVO> commentlist (String prd_no);
	//관리자화면에 추가되는 하둡처리결과(테이블로 저장)도 메소드로 추가
	List<CommentResultVO> commentResult ();
}
