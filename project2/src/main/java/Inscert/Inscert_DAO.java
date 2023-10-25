package Inscert;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Inscert_DAO {

	private SqlSession sqlSession;
	
	public Inscert_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Inscert_VO vo) {
		return sqlSession.insert("inscert.insert", vo);
	}

	public int update(Inscert_VO vo) {
		return sqlSession.update("inscert.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("inscert.delete", no);
	}
	
	public List<Inscert_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("inscert.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("inscert.selectOne", no);
	}
	
	public List<Map<String, Object>> inscert_vo(){
		return sqlSession.selectList("inscert.inscert_vo");
	}
	
}