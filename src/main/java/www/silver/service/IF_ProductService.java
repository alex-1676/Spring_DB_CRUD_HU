package www.silver.service;

import www.silver.VO.ProductVO;
import www.silver.VO.SearchVO;

import java.util.List;

public interface IF_ProductService {
    void addProduct(ProductVO productVO);

    ProductVO getProductById(String name);

    void addsearch(SearchVO searchVO);

    List<SearchVO> getSearchHistory();
}
