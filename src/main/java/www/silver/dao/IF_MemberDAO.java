package www.silver.dao;

import www.silver.VO.MemberVO;


public interface IF_MemberDAO {
    void addMember(MemberVO memberVO);

    String checkMember(String id);

    MemberVO checkID(String id);
}
