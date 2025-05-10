package www.silver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import www.silver.VO.FileVO;
import www.silver.VO.MemberVO;
import www.silver.dao.IF_MemberDAO;

import javax.inject.Inject;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements IF_MemberService {
    private final IF_MemberDAO ifMemberDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMember(MemberVO memberVO, String[] filenames) {
        ifMemberDAO.addMember(memberVO);

        if (filenames != null) {
            for (String fname : filenames) {
                if (fname != null) {

                    FileVO fileVO = new FileVO();

                    fileVO.setFilename(fname);
                    ifMemberDAO.attachFname(fileVO);
                }
            }
        }
    }

    @Override
    public String checkMember(String id) {
       return ifMemberDAO.checkMember(id);
    }

    @Override
    public MemberVO checkID(String id) {
        return ifMemberDAO.checkID(id);
    }
}
