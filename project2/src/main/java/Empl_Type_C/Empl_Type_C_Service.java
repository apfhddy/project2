package Empl_Type_C;

import java.util.List;

public class Empl_Type_C_Service {

	private Empl_Type_C_DAO empl_type_c_dao;
	
	public Empl_Type_C_Service(Empl_Type_C_DAO empl_type_c_dao) {
		this.empl_type_c_dao = empl_type_c_dao;
	}
	
	public List<Empl_Type_C_VO> selectList(){
		
		List<Empl_Type_C_VO> list = empl_type_c_dao.selectList();
		
		if(list.isEmpty()) {
			list = null;
		}
		return list;
	}
	
//	// CRUD
//	public int insert(Empl_Type_C_VO vo) {
//		int seq = empl_type_c_dao.getEmpl_no();
//		
//		vo.setEmpl_no(seq);
//		
//		return empl_type_c_dao.insert(vo);
//	}
//	
//	public int delete(int empl_no) {
//		return empl_type_c_dao.delete(empl_no);
//	}
//	
//	public int update(Empl_Type_C_VO vo) {
//		return empl_type_c_dao.update(vo);
//	}
	
	
}
