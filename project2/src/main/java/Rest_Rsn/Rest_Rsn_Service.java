package Rest_Rsn;

import java.util.List;
import java.util.Map;

public class Rest_Rsn_Service {

	private Rest_Rsn_DAO rest_rsn_dao;
	
	public Rest_Rsn_Service(Rest_Rsn_DAO rest_rsn_dao) {
		this.rest_rsn_dao = rest_rsn_dao;
	}
	
	public int insert(Rest_Rsn_VO vo) {
		return rest_rsn_dao.insert(vo);
	}
	
	public int update(Rest_Rsn_VO vo) {
		return rest_rsn_dao.update(vo);
	}
	
	public int delete(String no) {
		return rest_rsn_dao.delete(no);
	}
	
	public List<Rest_Rsn_VO> selectList(){
		return rest_rsn_dao.selectList();
	}
	
	public Map<String, Object> selectOne(String no){
		return rest_rsn_dao.selectOne(no);
	}
	
	
}

