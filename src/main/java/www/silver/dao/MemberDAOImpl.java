package www.silver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import www.silver.VO.MemberVO;

import javax.inject.Inject;

@Repository
public class MemberDAOImpl implements  IF_MemberDAO {

   @Inject
   SqlSession sqlSession;

    @Override
    public void addMember(MemberVO memberVO) {
        sqlSession.insert("www.silver.dao.IF_MemberDAO.insertone", memberVO);
    }

    @Override
    public String checkMember(String id) {
       return sqlSession.selectOne("www.silver.dao.IF_MemberDAO.checkMember", id);
    }

    @Override
    public MemberVO checkID(String id) {
        return sqlSession.selectOne("www.silver.dao.IF_MemberDAO.checkID", id);
    }
}
