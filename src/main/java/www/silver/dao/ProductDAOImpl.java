package www.silver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import www.silver.VO.ProductVO;
import www.silver.VO.SearchVO;
import www.silver.service.IF_ProductService;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ProductDAOImpl implements IF_ProductDAO {
    @Inject
    SqlSession sqlSession;
    @Override
    public void addProduct(ProductVO productVO) {
        sqlSession.insert("addProduct",productVO);
    }

    @Override
    public ProductVO getProductById(String name) {
       return sqlSession.selectOne("checkid",name);
    }

    @Override
    public void addsearch(SearchVO searchVO) {
        sqlSession.insert("addsearch",searchVO);
    }

    @Override
    public List<SearchVO> getSearchHistory() {
        return sqlSession.selectList("getSearchHistory");
    }
}
