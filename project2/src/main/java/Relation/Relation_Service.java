package Relation;

import java.util.List;

public class Relation_Service {

	private Relation_DAO relation_dao;
	
	public Relation_Service(Relation_DAO relation_dao) {
		this.relation_dao = relation_dao;
	}
	
	public int insert(Relation_VO vo) {
		return relation_dao.insert(vo);
	}
	
	public int update(Relation_VO vo) {
		return relation_dao.update(vo);
	}
	
	public int delete(String no) {
		return relation_dao.delete(no);
	}
	
	public List<Relation_VO> selectList(){
		return relation_dao.selectList();
	}
	
}
