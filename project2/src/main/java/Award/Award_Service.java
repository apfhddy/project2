package Award;

import org.springframework.stereotype.Service;


@Service
public class Award_Service {

	private Award_DAO awardDao;
	
	public Award_Service(Award_DAO awardDao) {
		this.awardDao = awardDao;
	}
	
	
	public Award_VO selectOne(String memberId) {
		return awardDao.selectOne(memberId);
	}
		
	public int insert(Award_VO vo) {
		
		return awardDao.insert(vo);
	}
	
	
	public int update(Award_VO vo) {
		return awardDao.update(vo);
	}
	
	public int getNo() {
		return awardDao.getNo();
	}
	
}




















