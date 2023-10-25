package Thesis;

import java.util.List;
import java.util.Map;

public class Thesis_Service {

	private Thesis_DAO thesis_dao;
	
	public Thesis_Service(Thesis_DAO thesis_dao) {
		this.thesis_dao = thesis_dao;
	}
	
	public int insert(Thesis_VO vo) {
		return thesis_dao.insert(vo);
	}
	
	public int update(Thesis_VO vo) {
		return thesis_dao.update(vo);
	}
	
	public int delete(String no) {
		return thesis_dao.delete(no);
	}
	
	public List<Thesis_VO> selectList(Map<String, Object> map){
		return thesis_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return thesis_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> thesis_vo(){
		return thesis_dao.thesis_vo();
	}
	
}
