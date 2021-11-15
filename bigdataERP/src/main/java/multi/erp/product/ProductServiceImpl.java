package multi.erp.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("productdao")
	ProductDAO dao;
	@Override
	public List<ProductVO> productlist(String category) {
		return dao.productlist(category);
	}
	@Override
	public List<ProductVO> hitproduct() {
		return dao.hitproduct();
	}
	@Override
	public List<ProductVO> newproduct() {
		return dao.newproduct();
	}

	@Override
	public ProductVO read(String prd_no) {
		// TODO Auto-generated method stub
		return dao.read(prd_no);
	}

}











