package Proj_Entry;

import java.util.List;
import java.util.Map;

public class Proj_Entry_Service {

	private Proj_Entry_DAO proj_entry_dao;
	
	public Proj_Entry_Service(Proj_Entry_DAO proj_entry_dao) {
		this.proj_entry_dao = proj_entry_dao;
	}
	
	public int insert(Proj_Entry_VO vo) {
		return proj_entry_dao.insert(vo);
	}
	
	public int udpate(Proj_Entry_VO vo) {
		return proj_entry_dao.update(vo);
	}
	
	public int delete(String no) {
		return proj_entry_dao.delete(no);
	}
	
	public List<Proj_Entry_VO> selectList(Map<String, Object> map){
		return proj_entry_dao.selectList(map);
	}

	public Map<String, Object> selectOne(String no){
		return proj_entry_dao.selectOne(no);
	}
	
}
