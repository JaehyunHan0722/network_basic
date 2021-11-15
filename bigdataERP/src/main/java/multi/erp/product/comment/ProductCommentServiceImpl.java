package multi.erp.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {
	@Autowired
	@Qualifier("productcommentdao")
	ProductCommentDAO dao;

	@Override
	public void writeComment(ProductCommentVO article) {
		dao.writeComment(article);
		
	}

	@Override
	public List<ProductCommentVO> commentlist(String prd_no) {
		// TODO Auto-generated method stub
		return dao.commentlist(prd_no);
	}
	@Override
	public List<CommentResultVO> commentResult() {
		// TODO Auto-generated method stub
		return dao.commentResult();
	}
}
