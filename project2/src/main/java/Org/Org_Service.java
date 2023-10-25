package Org;

import java.util.List;
import java.util.Map;

public class Org_Service {

	private Org_DAO org_dao;
	
	public Org_Service(Org_DAO org_dao) {
		this.org_dao = org_dao;
	}
	
	public int insert(Org_VO vo) {
		return org_dao.insert(vo);
	}
	
	public int update(Org_VO vo) {
		return org_dao.update(vo);
	}
	
	public int delete(String no) {
		return org_dao.delete(no);
	}
	
	public List<Org_VO> selectList(Map<String, Object> map){
		return org_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return org_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> org_vo(){
		return org_dao.org_vo();
	}
	
}
