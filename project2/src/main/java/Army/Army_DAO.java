package Army;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Army_DAO {

	private SqlSession sqlSession;
	
	public Army_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Army_VO vo) {
		return sqlSession.insert("army.insert", vo);
	}
	
	public int update(Army_VO vo) {
		return sqlSession.update("army.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("army.delete", no);
	}

	public List<Army_VO> selectList(){
		return sqlSession.selectList("army.selectList");
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("army.selectOne", no);
	}

	public List<Map<String, Object>> army_vo(){
		return sqlSession.selectList("army.army_vo");
	}
}
