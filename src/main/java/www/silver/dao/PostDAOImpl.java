package www.silver.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.VO.PostVO;

@Repository	
public class PostDAOImpl implements IF_PostDAO{
	
	@Inject
	private SqlSession sqlsession;

	@Override
	public void insertPost(PostVO pvo) {
		sqlsession.insert("www.silver.IF_PostDAO.insertpost", pvo);
	}

}
