package Rec_Ask;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Rec_Ask_DAO {

	private SqlSession sqlSession;
	
	public Rec_Ask_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Rec_Ask_VO vo) {
		return sqlSession.insert("rec_ask.insert", vo);
	}
	
	public int update(Rec_Ask_VO vo) {
		return sqlSession.update("rec_ask.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.update("rec_ask.delete", no);
	}
	
	public List<Rec_Ask_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("rec_ask.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("rec_ask.selectOne", no);
	}
	
	public List<Map<String, Object>> rec_ask_vo	(){
		return sqlSession.selectList("rec_ask.rec_ask_vo");
	}

	public Map<String, Object> content(String no) {
		return sqlSession.selectOne("rec_ask.content", no);
	}
	
}
