package Edu;

import java.util.List;
import java.util.Map;

public class Edu_Service {

	private Edu_DAO edu_dao;
	
	public Edu_Service(Edu_DAO edu_dao) {
		this.edu_dao = edu_dao;
	}
	
	public int insert(Edu_VO vo	) {
		return edu_dao.insert(vo); 
	}
	
	public int update(Edu_VO vo) {
		return edu_dao.update(vo);
	}
	
	public int delete(String no) {
		return edu_dao.delete(no);
	}
	
	public List<Edu_VO> selectList(Map<String, Object> map){
		return edu_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return edu_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> edu_vo(){
		return edu_dao.edu_vo();
	}
	
}