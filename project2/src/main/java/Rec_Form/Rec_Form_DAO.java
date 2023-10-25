package Rec_Form;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Rec_Form_DAO {

	private SqlSession sqlSession;
	
	public Rec_Form_DAO(SqlSession sqlSession) {
		this.sqlSession	= sqlSession;
	}
	
	public int insert(Rec_Form_VO vo) {
		return sqlSession.insert("rec_form.insert", vo);
	}
	
	public int update(Rec_Form_VO vo) {
		return sqlSession.update("rec_form.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("rec_form.delete", no);
	}
	
	public List<Rec_Form_VO> selectList(String no){
		return sqlSession.selectList("rec_form.selectList", no);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("rec_form.selectOne", no);
	}
	
	public Map<String, Object> content(String no){
		return sqlSession.selectOne("rec_form.content", no);
	}
	
	public List<Map<String, Object>> rec_form_vo(){
		return sqlSession.selectList("rec_form.rec_form_vo");
	}
	
	public List<Map<String, Object>> rec_all(String no){
		return sqlSession.selectList("rec_form.rec_all", no);
	}
}
