package Cert;

import java.util.List;
import java.util.Map;

public class Cert_Service {

	private Cert_DAO cert_dao;
	
	public Cert_Service(Cert_DAO cert_dao) {
		this.cert_dao = cert_dao;
	}
	
	public int insert(Cert_VO vo) {
		return cert_dao.insert(vo);
	}
	
	public int update(Cert_VO vo) {
		return cert_dao.update(vo);
	}
	
	public int delete(String no) {
		return cert_dao.delete(no);
	}
	
	public List<Cert_VO> selectList(Map<String, Object> map){
		return cert_dao.selectList(map);
	}
	
	public Map<String, Object> selectOne(String no){
		return cert_dao.selectOne(no);
	}
	
	public List<Map<String, Object>> cert_vo(){
		return cert_dao.cert_vo();
	}
	
}