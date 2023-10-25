package Exam;

import org.apache.ibatis.session.SqlSession;


public class Exam_DAO {
	
	private SqlSession sqlSession;
	
	public Exam_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Exam_VO vo) {
		return sqlSession.insert("exam.insert",vo);
	}
	
	public int update(Exam_VO vo) {
		return sqlSession.update("exam.update",vo);
	}
	
	public int getNo() {
		return sqlSession.selectOne("exam.getNo");
	}
	
	public Exam_VO selectOne(String memberId) {
		return sqlSession.selectOne("exam.selectOne", memberId);
	}
}





















