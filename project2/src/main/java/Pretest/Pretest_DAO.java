package Pretest;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Pretest_DAO {

	private SqlSession sqlSession;
	
	public Pretest_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Pretest_DAO() {
		super();
	}
	
	public List<Map<String, Object>> pretest_all_vo(){
		return sqlSession.selectList("pretest.pretest_all_vo");
	}
	
	public List<Pretest_VO> selectList(int no){
		
		List<Pretest_VO> list = sqlSession.selectList("pretest.selectList", no);
		
		return list;
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("pretest.selectOne", no);
	}
	
	public int insert(Pretest_VO vo) {
		return sqlSession.insert("pretest.insert", vo);
	}
	
	public int update(Pretest_VO vo) {
		return sqlSession.update("pretest.update", vo);
	}
	
	public int hidden(String no) {
		return sqlSession.update("pretest.hidden", no);
	}
	
	
	
}
