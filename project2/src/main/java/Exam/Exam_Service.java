package Exam;

import org.springframework.stereotype.Service;

@Service
public class Exam_Service {

	private Exam_DAO examDao;
	
	public Exam_Service(Exam_DAO examDao) {
		this.examDao = examDao;
	}
	
	
	public Exam_VO selectOne(String memberId) {
		return examDao.selectOne(memberId);
	}
		
	public int insert(Exam_VO vo) {
		
		return examDao.insert(vo);
	}
	
	
	public int update(Exam_VO vo) {
		return examDao.update(vo);
	}
	
	public int getNo() {
		return examDao.getNo();
	}
	
}



















