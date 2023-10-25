package Thesis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Thesis_DAO {

	private SqlSession sqlSession;
	
	public Thesis_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Thesis_VO vo) {
		return sqlSession.insert("thesis.insert", vo);
	}
	
	public int update(Thesis_VO vo) {
		return sqlSession.update("thesis.insert", vo);
	}

	public int delete(String no) {
		return sqlSession.delete("thesis.delete", no);
	}
	
	public List<Thesis_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("thesis.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("thesis,selectOne", no);
	}
	
	public List<Map<String, Object>> thesis_vo(){
		return sqlSession.selectList("thesis.thesis_vo"); 
	}
	
}
