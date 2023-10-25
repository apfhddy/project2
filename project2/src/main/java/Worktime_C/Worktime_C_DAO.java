package Worktime_C;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Worktime_C_DAO {

	private SqlSession sqlSession;
	
	public Worktime_C_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Worktime_C_VO> selectList(){
		return sqlSession.selectList("worktime_c.selectList");
	}
	
	public int insert(Worktime_C_VO vo) {
		return sqlSession.insert("worktime_c.insert", vo);
	}
	
	public int update(Worktime_C_VO vo) {
		return sqlSession.update("worktime_c.update", vo);
	}

	public int hidden(String no) {
		return sqlSession.update("worktime_c.hidden", no);
	}
	
}
