package Army;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class Army_Service {

	private Army_DAO army_dao;
	
	public Army_Service(Army_DAO army_dao) {
		this.army_dao = army_dao;
	}
	
	public int insert(Army_VO vo) {
		return army_dao.insert(vo);
	}
	
	public int update(Army_VO vo) {
		return army_dao.update(vo);
	}
	
	public int delete(String no) {
		return army_dao.delete(no);
	}

	public List<Army_VO> selectList(){
		return army_dao.selectList();
	}
	
	public Map<String, Object> selectOne(String no){
		return army_dao.selectOne(no);
	}

	public List<Map<String, Object>> army_vo(){
		return army_dao.army_vo();
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
