package www.silver.service;

import org.springframework.stereotype.Service;
import www.silver.VO.MemberVO;
import www.silver.dao.IF_MemberDAO;

import javax.inject.Inject;

@Service
public class MemberServiceImpl implements IF_MemberService {

   @Inject
    IF_MemberDAO ifMemberDAO;

    @Override
    public void addMember(MemberVO memberVO) {
        ifMemberDAO.addMember(memberVO);
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
