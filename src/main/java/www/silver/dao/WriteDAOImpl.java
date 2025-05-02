package www.silver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import www.silver.VO.WriteVO;

import javax.inject.Inject;
import java.util.List;

@Repository
public class WriteDAOImpl implements IF_WriteDAO {

    @Inject
    SqlSession sqlSession;
    @Override
    public void addWrite(WriteVO writevo) {
            sqlSession.insert("www.silver.dao.IF_WriteDAO.insertwrite", writevo);
    }

    @Override
    public List<WriteVO> getWriteList() {
       List<WriteVO> writeVOList= sqlSession.selectList("www.silver.dao.IF_WriteDAO.getwritelist");
        return writeVOList;
    }

    @Override
    //여기서 조회수 증가를 동시에
    public WriteVO getWriteByNo(int no) {
        sqlSession.update("www.silver.dao.IF_WriteDAO.plusWriteCnt", no);
        WriteVO writeVO = sqlSession.selectOne("www.silver.dao.IF_WriteDAO.getwriteNo", no);
        System.out.println(writeVO.getNo());
        return writeVO;
    }

}
