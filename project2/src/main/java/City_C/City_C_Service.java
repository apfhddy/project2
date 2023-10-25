package City_C;

import java.util.List;
import java.util.Map;

public class City_C_Service {

	private City_C_DAO city_c_dao;
	
	public City_C_Service(City_C_DAO city_c_dao) {
		this.city_c_dao = city_c_dao;
	}
	
	public List<City_C_VO> selectList(){
		return city_c_dao.selectList();
	}
	
	public Map<String, Object> selectOne(Map<String, Object> map){
		return city_c_dao.selectOne(map);
	}
	
}
