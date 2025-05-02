package www.silver.service;

import org.springframework.stereotype.Service;
import www.silver.VO.CommentVO;
import www.silver.dao.IF_CommentDAO;

import javax.inject.Inject;
import java.util.List;


@Service
public class CommentServiceImpl implements IF_CommentService {
    @Inject
    IF_CommentDAO commentDAO;

    @Override
    public List<CommentVO> getComments(int num) {
        List<CommentVO> comments = commentDAO.getComments(num);
        return comments;
    }

    @Override
    public void addComment(CommentVO commentVO) {
        //여기 욕설 필터링
        commentDAO.addComment(commentVO);
    }
}
