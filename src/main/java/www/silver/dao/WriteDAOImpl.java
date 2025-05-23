package www.silver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import www.silver.VO.PageVO;
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
    public List<WriteVO> getWriteList(PageVO pageVO) {
       List<WriteVO> writeVOList= sqlSession.selectList("www.silver.dao.IF_WriteDAO.getwritelist",pageVO);
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

    @Override
    public void addWriteImage(String fileNames, int no) {
        sqlSession.insert("www.silver.dao.IF_WriteDAO.insertWriteImage", fileNames);
    }

    @Override
    public List<String> getFiles(int no) {
        return sqlSession.selectList("www.silver.dao.IF_WriteDAO.getFiles", no);
    }

    @Override
    public int allCount() {
        return sqlSession.selectOne("www.silver.dao.IF_WriteDAO.allCount");
    }

    @Override
    public void delete(int no) {
        sqlSession.delete("www.silver.dao.IF_WriteDAO.deleteone", no);
    }

}
