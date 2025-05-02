package www.silver.service;

import org.springframework.stereotype.Service;
import www.silver.VO.WriteVO;
import www.silver.dao.IF_WriteDAO;

import javax.inject.Inject;
import java.util.List;

@Service
public class WriteServiceImpl implements IF_WriteService {
    @Inject
    IF_WriteDAO writeDAO;

    @Override
    public void addWrite(WriteVO writevo) {
        writeDAO.addWrite(writevo);
    }

    @Override
    public List<WriteVO> getWriteList() {
        List<WriteVO> writeVOList = writeDAO.getWriteList();
        return writeVOList;
    }

    @Override
    public WriteVO getWrite(int no) {
        return writeDAO.getWriteByNo(no);
    }
}
