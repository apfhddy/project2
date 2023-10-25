package Award;

import org.apache.ibatis.session.SqlSession;

public class Award_DAO {

	private SqlSession sqlSession;
	
	public Award_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Award_VO vo) {
		return sqlSession.insert("award.insert",vo);
	}
	
	public int update(Award_VO vo) {
		return sqlSession.update("award.update",vo);
	}
	
	public int getNo() {
		return sqlSession.selectOne("award.getNo");
	}
	
	public Award_VO selectOne(String memberId) {
		return sqlSession.selectOne("award.selectOne", memberId);
	}
}






















