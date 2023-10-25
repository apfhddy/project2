package Career;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Career_DAO {

	private SqlSession sqlSession;
	
	public Career_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Career_VO vo) {
		return sqlSession.insert("career.insert", vo);
	}
	
	public int update(Career_VO vo) {
		return sqlSession.update("career.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("career.delete", no);
	}
	
	public List<Career_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("career.selectList",map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("career.selectOne", no);
	}
	
	public List<Map<String, Object>> career_vo(){
		return sqlSession.selectList("career.career_vo");
	}
	
}
