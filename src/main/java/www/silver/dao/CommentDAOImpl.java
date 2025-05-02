package www.silver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import www.silver.VO.CommentVO;

import javax.inject.Inject;
import java.util.List;

@Repository
public class CommentDAOImpl implements IF_CommentDAO {
    @Inject
    SqlSession sqlSession;

    @Override
    public List<CommentVO> getComments(int num) {

        List<CommentVO> comments = sqlSession.selectList("www.silver.dao.IF_CommentDAO.getComments", num);
        return comments;
    }

    @Override
    public void addComment(CommentVO commentVO) {
        sqlSession.insert("insertComment", commentVO);
    }
}
