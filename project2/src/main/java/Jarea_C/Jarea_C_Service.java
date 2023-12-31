package Jarea_C;

import java.util.List;

public class Jarea_C_Service {

	private Jarea_C_DAO jarea_c_dao;
	
	public Jarea_C_Service(Jarea_C_DAO jarea_c_dao) {
		this.jarea_c_dao = jarea_c_dao;
	}
	
	public List<Jarea_C_VO> selectList(){
		
		List<Jarea_C_VO> list = jarea_c_dao.selectList();
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}
	
}
