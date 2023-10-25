package Rest;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Rest_DAO {

	private SqlSession sqlSession;
	
	public Rest_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(Rest_VO vo) {
		return sqlSession.insert("rest.insert", vo);
	}
	
	public int update(Rest_VO vo) {
		return sqlSession.update("rest.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("rest.delete", no);
	}
		
	public List<Rest_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("rest.selectList", map);
	}
		
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("rest.selectOne", no);
	}
	
	public List<Map<String, Object>> rest_vo(){
		return sqlSession.selectList("rest.rest_vo");
	}
}