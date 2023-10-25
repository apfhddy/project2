package Rest_Rsn;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Rest_Rsn_DAO {

	private SqlSession sqlSession;
	
	public Rest_Rsn_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Rest_Rsn_VO vo) {
		return sqlSession.insert("rest_rsn.insert", vo);
	}
	
	public int update(Rest_Rsn_VO vo) {
		return sqlSession.update("rest_rsn.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("rest_rsn.delete", no);
	}
	
	public List<Rest_Rsn_VO> selectList(){
		return sqlSession.selectList("rest_rsn.selectList");
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("rest_rsn.selectOne", no);
	}
	
}