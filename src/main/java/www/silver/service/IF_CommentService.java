package www.silver.service;

import www.silver.VO.CommentVO;

import java.util.List;

public interface IF_CommentService {
    List<CommentVO> getComments(int num);

    void addComment(CommentVO commentVO);
}
