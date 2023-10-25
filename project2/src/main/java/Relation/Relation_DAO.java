package Relation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Relation_DAO {

	private SqlSession sqlSession;
	
	public Relation_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Relation_VO vo) {
		return sqlSession.insert("relattion.insert", vo);
	}
	
	public int update(Relation_VO vo) {
		return sqlSession.update("relation.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("relation.delete", no);
	}
	
	public List<Relation_VO> selectList(){
		return sqlSession.selectList("relation.selectList");
	}
	
}
