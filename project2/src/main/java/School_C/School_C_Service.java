package School_C;

import java.util.List;

public class School_C_Service {

	private School_C_DAO school_c_dao;
	
	public School_C_Service(School_C_DAO school_c_dao) {
		this.school_c_dao = school_c_dao;
	}
	
	public List<School_C_VO> selectList(){
		
		List<School_C_VO> list = school_c_dao.selectList();
		
		if(list.isEmpty()) {
			list = null;
		}
		return list;
	}
	
	
	
}
