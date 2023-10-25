package Rest;

import java.util.List;
import java.util.Map;

public class Rest_Service {

	private Rest_DAO rest_dao;
	
	public Rest_Service(Rest_DAO rest_dao) {
		this.rest_dao = rest_dao;
	}
	
	public int insert(Rest_VO vo) {
		return rest_dao.insert(vo);
	}
	
	public int update(Rest_VO vo) {
		return rest_dao.update(vo);
	}
	
	public int delete(String no) {
		return rest_dao.delete(no);
	}

	public List<Rest_VO> selectList(Map<String, Object> map){
		return rest_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return rest_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> rest_vo(){
		return rest_dao.rest_vo();
	}
	
}