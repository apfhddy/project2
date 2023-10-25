package Cert;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Cert_DAO {

	private SqlSession sqlSession;
	
	public Cert_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Cert_VO vo) {
		return sqlSession.insert("cert.insert", vo);
	}
	
	public int update(Cert_VO vo) {
		return sqlSession.update("cert.update", vo);
	}
	
	public int delete(String no) {
		return sqlSession.delete("cert.delete", no);
	}
	
	public List<Cert_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("cert.selectList", map);
	}
	
	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("cert.selectOne", no);
	}
	
	public List<Map<String, Object>> cert_vo(){
		return sqlSession.selectList("cert.cert_vo");
	}
	
}
