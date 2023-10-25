package Edu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Edu_DAO {
	
	private SqlSession sqlSession;
	
	public Edu_DAO(SqlSession sqlSession) {
		this.sqlSession	= sqlSession;
	}
	
	public int insert(Edu_VO vo) {
		return sqlSession.insert("edu.insert", vo);
	}
	
	public int update(Edu_VO vo) {
		return sqlSession.update("edu.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("edu.delete", no);
	}
	
	public List<Edu_VO> selectList(Map<String, Object>map){
		return sqlSession.selectList("edu.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("edu.selectOne", no);
	}
	
	public List<Map<String, Object>> edu_vo(){
		return sqlSession.selectList("edu.edu_vo");
	}
	
}