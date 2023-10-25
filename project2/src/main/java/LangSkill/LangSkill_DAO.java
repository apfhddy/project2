package LangSkill;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class LangSkill_DAO {

	private SqlSession sqlSession;
	
	public LangSkill_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(LangSkill_VO vo) {
		return sqlSession.insert("langskill.insert", vo);
	}
	
	public int update(LangSkill_VO vo) {
		return sqlSession.update("langskill.insert", vo);
	}

	public int delete(String no) {
		return sqlSession.delete("langskill.delete", no);
	}
	
	public List<LangSkill_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("langskill.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("langskill,selectOne", no);
	}
	
	public List<Map<String, Object>> langskill_vo(){
		return sqlSession.selectList("langskill.langskill_vo"); 
	}
	
}
