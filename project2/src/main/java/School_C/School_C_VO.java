package School_C;

public class School_C_VO {

	private int school_cno;
	private String school_type;
	
	public School_C_VO() {
		super();
	}

	public School_C_VO(String school_type) {
		this.school_type = school_type;
	}

	public School_C_VO(int school_cno, String school_type) {
		this.school_cno = school_cno;
		this.school_type = school_type;
	}

	public int getSchool_cno() {
		return school_cno;
	}

	public void setSchool_cno(int school_cno) {
		this.school_cno = school_cno;
	}

	public String getSchool_type() {
		return school_type;
	}

	public void setSchool_type(String school_type) {
		this.school_type = school_type;
	}
	
	
}
