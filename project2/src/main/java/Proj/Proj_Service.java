package Proj;

import java.util.List;
import java.util.Map;

public class Proj_Service {

	private Proj_DAO proj_dao;
	
	public Proj_Service(Proj_DAO proj_dao) {
		this.proj_dao = proj_dao;
	}
	
	public int insert(Proj_VO vo) {
		return proj_dao.insert(vo);
	}
	
	public int update(Proj_VO vo) {
		return proj_dao.update(vo);
	}
	
	public int delete(String no) {
		return proj_dao.delete(no);
	}
	
	public List<Proj_VO> selectList(Map<String, Object> map){
		return proj_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return proj_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> proj_vo(){
		return proj_dao.proj_vo();
	}
	
}