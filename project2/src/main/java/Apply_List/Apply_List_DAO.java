package Apply_List;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Apply_List_DAO {

	private SqlSession sqlSession;
	
	public Apply_List_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Apply_List_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("apply_list.selectList", map);
	}

	public Map<String, Object> selectOne(String no){
		return sqlSession.selectOne("apply_list.selectOne", no);
	}
	
	// CRUD (회원 본인의 지원 내역에 대한 영역)
	public int insert(Apply_List_VO vo) {
		return sqlSession.insert("apply_list.insert", vo);
	}
	
	public int update(Apply_List_VO vo) {
		return sqlSession.update("apply_list.update", vo);
	}
	
	public int hidden(String no) {						// 삭제시 숨김처리
		return sqlSession.update("apply_list_hidden", no);
	}
	
}
