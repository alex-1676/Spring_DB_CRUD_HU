package www.silver.dao;

import www.silver.VO.CommentVO;

import java.util.List;

public interface IF_CommentDAO {
    List<CommentVO> getComments(int num);

    void addComment(CommentVO commentVO);
}
