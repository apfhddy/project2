package Jstat;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Jstat_DAO {

	private SqlSession sqlSession;
	
	public Jstat_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Jstat_VO vo) {
		return sqlSession.insert("jstat.insert", vo);
	}
	
	public int update(Jstat_VO vo) {
		return sqlSession.update("jstat.insert", vo);
	}

	public int delete(String no) {
		return sqlSession.delete("jstat.delete", no);
	}
	
	public List<Jstat_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("jstat.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("jstat.selectOne", no);
	}
	
	public List<Map<String, Object>> jstat_vo(){
		return sqlSession.selectList("jstat.jstat_vo"); 
	}
	
}
