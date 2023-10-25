package Apply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Apply_DAO {
	
	private SqlSession sqlSession;
	
	public Apply_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Apply_DAO() {
		super();
	}
	
	public List<Apply_VO> selectList(){
		return sqlSession.selectList("apply.selectList");
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("apply.selectOne", no);
	}
	
	public Map<String, Object> getContent(String no){
		return sqlSession.selectOne("apply.getContent", no);
	}
	
	// apply / apply_form / army 칼럼들 사용
	public List<Map<String, Object>> apply_all_vo(String no){
		return sqlSession.selectList("apply.apply_all_vo", no);
		
	}
	
	// apply / apply_form 칼럼들 사용
	public List<Map<String, Object>> apply_vo(){
		return sqlSession.selectList("apply.apply_vo");
		
	}
	
	public int insert(Apply_VO vo) {
		return sqlSession.insert("apply.insert", vo);
	}
	
	public int update(Apply_VO vo) {
		return sqlSession.update("apply.update", vo);
	}
	
	public int hidden(String no) {
		return sqlSession.update("apply.hidden", no);
	}
	
	
}
