package Pretest_Q;

import java.util.List;
import java.util.Map;

public class Pretest_Q_Service {

	private Pretest_Q_DAO pretest_q_dao;
	
	public Pretest_Q_Service(Pretest_Q_DAO pretest_q_dao) {
		this.pretest_q_dao = pretest_q_dao;
	}
	
	public int insert(Pretest_Q_VO vo) {
		return pretest_q_dao.insert(vo);
	}
	
	public int update(Pretest_Q_VO vo) {
		return pretest_q_dao.update(vo);
	}
	
	public List<Map<String, Object>> question_list(){
		return pretest_q_dao.question_list();
	}

	public List<Pretest_Q_VO> selectList(int no){
		return pretest_q_dao.selectList(no);
	}
	
	public Map<String, Object> selectOne(Map<String, Object> map){
		return pretest_q_dao.selectOne(map);
	}
	
	
	
}
