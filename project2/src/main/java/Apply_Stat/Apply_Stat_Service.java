package Apply_Stat;

public class Apply_Stat_Service {

	private Apply_Stat_DAO apply_stat_dao;
	
	public Apply_Stat_Service(Apply_Stat_DAO apply_stat_dao) {
		this.apply_stat_dao = apply_stat_dao;
	}
	
	public int insert(Apply_Stat_VO vo) {
		return apply_stat_dao.insert(vo);
	}
	
	public int update(Apply_Stat_VO vo) {
		return apply_stat_dao.update(vo);
	}
	
	public int hidden(String no) {
		return apply_stat_dao.hidden(no);
	}
	
}
