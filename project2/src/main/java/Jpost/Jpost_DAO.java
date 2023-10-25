package Jpost;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Jpost_DAO {
	
	// sqlSession 객체 생성 (DAO 사용에 필요)
	private SqlSession sqlSession;
	
	// sqlSession 객체를 사용할 DAO
	public Jpost_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// selectList 생성
	// - service에서 사용할 메소드로 return
	public List<Jpost_VO> selectList(Map<String, Object> map){
		return sqlSession.selectList("jpost.selectList",map);
	}

	// selectOne 생성
	// - Jpost_id를 통해 리스트 하나씩 호출 
	public Map<String, Object> selectOne(String no) { 
		return sqlSession.selectOne("jpost.selectOne", no);
	}
	
	// CRUD
	public int insert(Jpost_VO vo) {
		return sqlSession.insert("jpost.insert", vo);
	}	

	public int update(Jpost_VO vo) {							// vo 데이터를 받아서 처리해야하기 때문에 파라미터도 vo
		return sqlSession.update("jpost.update", vo);
	}

	public int hidden(String no) {								// 삭제 버튼 클릭시, 숨김처리
		return sqlSession.update("jpost.hidden", no);
	}
	
	
	public int getNo() {										// Controller에서 유저한테 받은 값을 저장한 vo의 데이터 중 no에 해당하는 값을 기입하기 위해서
		return sqlSession.selectOne("jpost.getNo");
	}

	
	// 게시글 내용 관련 메소드
	public int hitCnt(String no) {								// 특정 채용공고 게시글의 조회수 메소드
		return sqlSession.update("jpost.hitCnt", no);
	}
	
	public Map<String, Object> getContent(String no){			// 채용공고 게시글 클릭시 실행 / String no 값으로 jpost_id를 담는다
		return sqlSession.selectOne("jpost.getContent", no);
	}
	
	// 고용형태 관련 메소드
	// jpost / jpost_detail 칼럼들을 all_list에 다 넣기
	public List<Map<String, Object>> all_list(){
		return sqlSession.selectList("jpost.all_list");
	}

	public List<Jpost_VO> jpost_vo(String no){
		return sqlSession.selectList("jpost.jpost_vo", no);
	}
	
	
	
}

