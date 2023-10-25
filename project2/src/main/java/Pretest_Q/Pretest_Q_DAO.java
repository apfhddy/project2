package Pretest_Q;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Pretest_Q_DAO {

	private SqlSession sqlSession;
	
	public Pretest_Q_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Pretest_Q_VO vo) {
		return sqlSession.insert("pretest_q.insert",vo);
	}
	
	public int update(Pretest_Q_VO vo) {
		return sqlSession.update("pretest_q.update",vo);
	}
	
	public List<Map<String, Object>> question_list(){
		return sqlSession.selectList("pretest_q.question_list");
	}
	
	public List<Pretest_Q_VO> selectList(int no){
		return sqlSession.selectList("pretest_q.selectList", no);
	}
	
	public Map<String, Object> selectOne(Map<String, Object> map){
		return sqlSession.selectOne("pretest_q.selectOne",map);
	}



}

