package www.silver.service;

import www.silver.VO.WriteVO;

import java.util.List;

public interface IF_WriteService {
    public void addWrite(WriteVO writevo);

    public List<WriteVO> getWriteList();

    public WriteVO getWrite(int no);
}
