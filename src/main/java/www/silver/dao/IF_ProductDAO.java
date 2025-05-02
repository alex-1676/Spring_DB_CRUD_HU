package www.silver.dao;

import www.silver.VO.ProductVO;
import www.silver.VO.SearchVO;

import java.util.List;

public interface IF_ProductDAO {
    void addProduct(ProductVO productVO);

    ProductVO getProductById(String name);

    void addsearch(SearchVO searchVO);

    List<SearchVO> getSearchHistory();
}
