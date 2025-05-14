package www.silver.dao;

import www.silver.VO.PageVO;
import www.silver.VO.WriteVO;

import java.util.List;

public interface IF_WriteDAO {
    public void addWrite(WriteVO writevo);

    public List<WriteVO> getWriteList(PageVO pageVO);

    public WriteVO getWriteByNo(int no);

    public void addWriteImage(String fileNames, int no);

    List<String> getFiles(int no);

    int allCount();

    void delete(int no);
}
