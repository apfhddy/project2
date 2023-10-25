package Apply_Stat;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Apply_Stat_DAO {

	private SqlSession sqlSession;
	
	public Apply_Stat_DAO(SqlSession sqlSession) {
		this.sqlSession	= sqlSession;
	}
	
	public int insert(Apply_Stat_VO vo) {
		return sqlSession.insert("apply_stat.insert", vo);
	}
	
	public int update(Apply_Stat_VO vo) {
		return sqlSession.update("apply_stat.update", vo);
	}
	
	public int hidden(String no) {
		return sqlSession.update("apply_stat.hidden", no);
	}
	
	public List<Apply_Stat_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("apply_stat.selectList", map);
	}
	
	
}
