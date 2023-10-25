package Empl_Type_C;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Empl_Type_C_DAO {

	private SqlSession sqlSession;
	
	public Empl_Type_C_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Empl_Type_C_VO> selectList(){
		return sqlSession.selectList("empl_type_c.selectList");
	}
	
	public int insert(Empl_Type_C_VO vo) {
		return sqlSession.insert("empl_type_c.insert", vo);
	}
	
	public int update(Empl_Type_C_VO vo) {
		return sqlSession.update("empl_type_c.update", vo);
	}
	
	public int delete(int empl_no) {
		return sqlSession.delete("empl_type_c.delete", empl_no);
	}
	
	public int getEmpl_no() {
		return sqlSession.selectOne("empl_type_c.getEmpl_no");
	}
	
}
