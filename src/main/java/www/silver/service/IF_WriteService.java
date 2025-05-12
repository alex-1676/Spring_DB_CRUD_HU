package www.silver.service;

import www.silver.VO.PageVO;
import www.silver.VO.WriteVO;

import java.util.List;

public interface IF_WriteService {
    public void addWrite(WriteVO writev,List<String> fileNames);

    public List<WriteVO> getWriteList(PageVO pageVO);

    public WriteVO getWrite(int no);

    List<String> getFiles(int no);

    int allCount();
}
