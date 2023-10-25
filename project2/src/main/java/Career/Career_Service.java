package Career;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class Career_Service {

	private Career_DAO career_dao;
	
	public Career_Service(Career_DAO career_dao) {
		this.career_dao = career_dao;
	}
	
	public int insert(Career_VO	vo) {
		return career_dao.insert(vo);
	}
	
	public int update(Career_VO vo){
		return career_dao.update(vo);
	}

	public int delete(String no) {
		return career_dao.delete(no);
	}
	
	public List<Career_VO> selectList(Map<String, Object> map){
		return career_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return career_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> career_vo(){
		return career_dao.career_vo();
	}
	
	// Controller에서 String을 Date로 형변환 하는 메소드
	public static Date getSQLDate(String date) {
	    SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
	      
	    java.util.Date sd = null;
	   
	    try {
	    	sd = spd.parse(date);
	    	
	    } catch (java.text.ParseException e) {
	    } 
    
		long d = sd.getTime();
	    Date sqlD = new Date(d);
	    return sqlD;
	}
	
}

