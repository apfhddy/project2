package Vol;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Vol_DAO {

	private SqlSession sqlSession;
	
	public Vol_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Vol_VO vo) {
		return sqlSession.insert("vol.insert", vo);
	}
	
	public int update(Vol_VO vo) {
		return sqlSession.update("vol.insert", vo);
	}

	public int delete(String no) {
		return sqlSession.delete("vol.delete", no);
	}
	
	public List<Vol_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("vol.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("vol,selectOne", no);
	}
	
	public List<Map<String, Object>> vol_vo(){
		return sqlSession.selectList("vol.vol_vo"); 
	}
	
}
