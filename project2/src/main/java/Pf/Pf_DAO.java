package Pf;

import org.apache.ibatis.session.SqlSession;

public class Pf_DAO {

	private SqlSession sqlSession;
	
	public Pf_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Pf_VO vo) {
		return sqlSession.insert("pf.insert",vo);
	}
	
	public int update(Pf_VO vo) {
		return sqlSession.update("pf.update",vo);
	}
	
	public int hit(int no) {
		return sqlSession.update("pf.hit",no);
	}
	
	public int getNo() {
		return sqlSession.selectOne("pf.getNo");
	}
	
	public Pf_VO selectOne(String memberId) {
		return sqlSession.selectOne("pf.selectOne", memberId);
	}
}






















