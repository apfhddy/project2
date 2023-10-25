package Rec_Form;

import java.util.List;
import java.util.Map;

public class Rec_Form_Service {

	private Rec_Form_DAO rec_form_dao;
	
	public Rec_Form_Service(Rec_Form_DAO rec_form_dao) {
		this.rec_form_dao = rec_form_dao;
	}
	
	public int insert(Rec_Form_VO vo) {
		return rec_form_dao.insert(vo);
	}
	
	public int update(Rec_Form_VO vo) {
		return rec_form_dao.update(vo);
	}
	
	public int delete(String no) {
		return rec_form_dao.delete(no);
	}
	
	public List<Rec_Form_VO> selectList(String no){
		return rec_form_dao.selectList(no);
	}
	
	public Map<String, Object> selectOne(String no){
		return rec_form_dao.selectOne(no);
	}
	
	public Map<String, Object> content(String no){
		return rec_form_dao.content(no);
	}
	
	public List<Map<String, Object>> rec_form_vo(){
		return rec_form_dao.rec_form_vo();
	}
	
	public List<Map<String, Object>> rec_all(String no){
		return rec_form_dao.rec_all(no);
	}
	
}
