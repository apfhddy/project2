package Vol;

import java.util.List;
import java.util.Map;

public class Vol_Service {

	private Vol_DAO vol_dao;
	
	public Vol_Service(Vol_DAO vol_dao) {
		this.vol_dao = vol_dao;
	}
	
	public int insert(Vol_VO vo) {
		return vol_dao.insert(vo);
	}
	
	public int update(Vol_VO vo) {
		return vol_dao.update(vo);
	}
	
	public int delete(String no) {
		return vol_dao.delete(no);
	}
	
	public List<Vol_VO> selectList(Map<String, Object> map){
		return vol_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return vol_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> vol_vo(){
		return vol_dao.vol_vo();
	}
	
}
