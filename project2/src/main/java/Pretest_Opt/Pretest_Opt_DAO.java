package Pretest_Opt;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Pretest_Opt_DAO {

	private SqlSession sqlSession;
	
	public Pretest_Opt_DAO(SqlSession sqlSession) {
		this.sqlSession	 = sqlSession;
	}
	
	public int insert(Pretest_Opt_VO vo) {
		return sqlSession.insert("pretest_opt.insert",vo);
	}
	
	public int update(Pretest_Opt_VO vo) {
		return sqlSession.update("pretest_opt.update",vo);
	}
	
	public List<Map<String, Object>> opt_list(){
		return sqlSession.selectList("pretest_opt.opt_list");
	}
	
	public List<Pretest_Opt_VO> selectList(int no){
		return sqlSession.selectList("pretest_opt.selectList", no);
	}
	
	public Map<String, Object> selectOne(Map<String, Object> map){
		return sqlSession.selectOne("pretest_opt.selectOne", map);
	}
	
	
	
	
	
	
}
