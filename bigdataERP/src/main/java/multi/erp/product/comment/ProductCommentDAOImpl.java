package multi.erp.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productcommentdao")
public class ProductCommentDAOImpl implements ProductCommentDAO {
	@Autowired
	SqlSession sqlsession;

	@Override
	public void writeComment(ProductCommentVO article) {
		sqlsession.insert("multi.shop.product.comment.write", article);		
	}

	@Override
	public List<ProductCommentVO> commentlist(String prd_no) {
		return sqlsession.selectList("multi.shop.product.comment.list", prd_no);
	}
	@Override
	public List<CommentResultVO> commentResult() {
		return  sqlsession.selectList("multi.shop.product.comment.comment_result");
	}	

	
}
