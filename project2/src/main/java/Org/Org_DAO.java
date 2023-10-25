package Org;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Org_DAO {

	private SqlSession sqlSession;
	
	public Org_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Org_VO vo) {
		return sqlSession.insert("org.insert", vo);
	}
	
	public int update(Org_VO vo) {
		return sqlSession.update("org.insert", vo);
	}

	public int delete(String no) {
		return sqlSession.delete("org.delete", no);
	}
	
	public List<Org_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("org.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("org,selectOne", no);
	}
	
	public List<Map<String, Object>> org_vo(){
		return sqlSession.selectList("org.org_vo"); 
	}
	
}
