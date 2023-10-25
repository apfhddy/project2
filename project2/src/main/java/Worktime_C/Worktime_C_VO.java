package Worktime_C;

public class Worktime_C_VO {
	
	private int worktime_cno;
	private String worktime_type;
	
	public Worktime_C_VO() {
		super();
	}

	public Worktime_C_VO(int worktime_cno, String worktime_type) {
		this.worktime_cno = worktime_cno;
		this.worktime_type = worktime_type;
	}

	public Worktime_C_VO(int worktime_no) {
		this.worktime_cno = worktime_no;
	}

	public Worktime_C_VO(String worktime_type) {
		this.worktime_type = worktime_type;
	}
	
	public int getWorktime_cno() {
		return worktime_cno;
	}

	public void setWorktime_cno(int worktime_cno) {
		this.worktime_cno = worktime_cno;
	}

	public String getWorktime_type() {
		return worktime_type;
	}

	public void setWorktime_type(String worktime_type) {
		this.worktime_type = worktime_type;
	}


}
