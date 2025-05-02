package www.silver.service;

import www.silver.VO.MemberVO;

public interface IF_MemberService {

    void addMember(MemberVO memberVO);

    String checkMember(String id);

   MemberVO checkID(String id);
}
