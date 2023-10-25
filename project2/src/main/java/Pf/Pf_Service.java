package Pf;

import org.springframework.stereotype.Service;

@Service
public class Pf_Service {

	private Pf_DAO pf_ado;
	
	public Pf_Service(Pf_DAO pf_ado) {
		this.pf_ado = pf_ado;
	}
	
	public Pf_VO selectOne(String memberId) {
		return pf_ado.selectOne(memberId);
	}
		
	public int insert(Pf_VO vo) {
		return pf_ado.insert(vo);
	}
	
	
	public int update(Pf_VO vo) {
		return pf_ado.update(vo);
	}
	
	public int getNo() {
		return pf_ado.getNo();
	}
	
}



















