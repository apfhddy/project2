package LangSkill;

import java.util.List;
import java.util.Map;

public class LangSkill_Service {

	private LangSkill_DAO langSkill_dao;
	
	public LangSkill_Service(LangSkill_DAO langSkill_dao) {
		this.langSkill_dao = langSkill_dao;
	}
	
	public int insert(LangSkill_VO vo) {
		return langSkill_dao.insert(vo);
	}
	
	public int update(LangSkill_VO vo) {
		return langSkill_dao.update(vo);
	}
	
	public int delete(String no) {
		return langSkill_dao.delete(no);
	}
	
	public List<LangSkill_VO> selectList(Map<String, Object> map){
		return langSkill_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return langSkill_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> langskill_vo(){
		return langSkill_dao.langskill_vo();
	}
	
}
