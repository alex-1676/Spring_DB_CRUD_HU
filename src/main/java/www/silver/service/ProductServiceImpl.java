package www.silver.service;

import org.springframework.stereotype.Service;
import www.silver.VO.ProductVO;
import www.silver.VO.SearchVO;
import www.silver.dao.IF_ProductDAO;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProductServiceImpl implements IF_ProductService {
    @Inject
    IF_ProductDAO productDAO;

    @Override
    public void addProduct(ProductVO productVO) {
        productDAO.addProduct(productVO);
    }

    @Override
    public ProductVO getProductById(String name) {
        return productDAO.getProductById(name);
    }

    @Override
    public void addsearch(SearchVO searchVO) {
        productDAO.addsearch(searchVO);
    }

    @Override
    public List<SearchVO> getSearchHistory() {
       return productDAO.getSearchHistory();
    }
}
