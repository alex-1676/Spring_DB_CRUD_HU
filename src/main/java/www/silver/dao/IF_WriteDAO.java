package www.silver.dao;

import www.silver.VO.WriteVO;

import java.util.List;

public interface IF_WriteDAO {
    public void addWrite(WriteVO writevo);

    public List<WriteVO> getWriteList();

    public WriteVO getWriteByNo(int no);

    public void addWriteImage(String fileNames, int no);

    List<String> getFiles(int no);
}
