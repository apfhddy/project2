package Jstat_C;

public class Jstat_C_VO {

	private int jstat_cno;
	private String jstat_stat
	;
	
	public Jstat_C_VO() {
		super();
	}
	
	public Jstat_C_VO(int jstat_cno, String jstat_stat) {
		this.jstat_cno = jstat_cno;
		this.jstat_stat = jstat_stat;
	}

	public int getJstat_cno() {
		return jstat_cno;
	}

	public void setJstat_cno(int jstat_cno) {
		this.jstat_cno = jstat_cno;
	}

	public String getJstat_stat() {
		return jstat_stat;
	}

	public void setJstat_stat(String jstat_stat) {
		this.jstat_stat = jstat_stat;
	}
	
	
	
}
