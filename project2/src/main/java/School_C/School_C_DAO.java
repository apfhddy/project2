package School_C;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class School_C_DAO {

	private SqlSession sqlSession;
	
	public School_C_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<School_C_VO> selectList(){
		return sqlSession.selectList("school_c.selectList");
	}
	
	public int insert(School_C_VO vo) {
		return sqlSession.insert("school_c.insert", vo);
	}
	
	public int update(School_C_VO vo) {
		return sqlSession.update("school_c.update", vo);
	}
	
	public int delete(int school_cno) {
		return sqlSession.delete("school_c.delete", school_cno);
	}
	
	
}
