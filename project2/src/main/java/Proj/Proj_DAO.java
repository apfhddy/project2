package Proj;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Proj_DAO {

	private SqlSession sqlSession;
	
	public Proj_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Proj_VO vo) {
		return sqlSession.insert("proj.insert", vo);
	}
	
	public int update(Proj_VO vo) {
		return sqlSession.update("proj.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("proj.delete", no);
	}
	
	public List<Proj_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("proj.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("proj.selectOne", no);
	}
	
	public List<Map<String, Object>> proj_vo(){
		return sqlSession.selectList("proj.proj_vo");
	}
	
}