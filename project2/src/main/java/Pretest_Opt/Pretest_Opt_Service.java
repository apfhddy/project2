package Pretest_Opt;

import java.util.List;
import java.util.Map;

public class Pretest_Opt_Service {

	private Pretest_Opt_DAO pretest_opt_dao;
	
	public Pretest_Opt_Service(Pretest_Opt_DAO pretest_opt_dao) {
		this.pretest_opt_dao = pretest_opt_dao;
	}
	
	public int insert(Pretest_Opt_VO vo	) {
		return pretest_opt_dao.insert(vo);
	}
	
	public int update(Pretest_Opt_VO vo) {
		return pretest_opt_dao.update(vo);
	}
	
	public List<Map<String, Object>> opt_list(){
		return pretest_opt_dao.opt_list();
	}
	
	public List<Pretest_Opt_VO> selectList(int no){
		return pretest_opt_dao.selectList(no);
	}
	
	public Map<String, Object> selectOne(Map<String, Object> map){
		return pretest_opt_dao.selectOne(map);
	}
	
	
}
