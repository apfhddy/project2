package Pretest;

import java.util.List;
import java.util.Map;

public class Pretest_Service {

	private Pretest_DAO pretest_dao;
	
	public Pretest_Service(Pretest_DAO pretest_dao) {
		this.pretest_dao = pretest_dao;
	}
	
	public int insert(Pretest_VO vo) {
		return pretest_dao.insert(vo);
	}
	
	public int update(Pretest_VO vo) {
		return pretest_dao.update(vo);
	}
	
	public int hidden(String no) {
		return pretest_dao.hidden(no);
	}
	
	public List<Map<String, Object>> pretest_all_vo(){
		return pretest_dao.pretest_all_vo();
	}
	
	
	public List<Pretest_VO> selectList(int no){
		
		List<Pretest_VO> list = pretest_dao.selectList(no);
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}

	public Map<String, Object> selectOne(String no){
		return pretest_dao.selectOne(no);
	}
	
}
