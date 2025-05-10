package www.silver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import www.silver.VO.WriteVO;
import www.silver.dao.IF_WriteDAO;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WriteServiceImpl implements IF_WriteService {

   private final IF_WriteDAO writeDAO;

    @Override
    public void addWrite(WriteVO writevo,List<String> fileNames) {
        writeDAO.addWrite(writevo);

        List<String> validFileNames = fileNames.stream()
                .filter(fileName -> !fileName.isEmpty())
                .collect(Collectors.toList());

        if(!validFileNames.isEmpty()) {
            for (String validFileName : validFileNames) {
                if(!validFileName.isEmpty()){
                    writeDAO.addWriteImage(validFileName,writevo.getNo());
                }
            }

        }
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

    @Override
    public List<String> getFiles(int no) {
        return writeDAO.getFiles(no);
    }
}
