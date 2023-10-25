package Lv_C;

public class Lv_C_VO {

	private int lv_cno;
	private String lv_type;
	
	public Lv_C_VO() {
		super();
	}

	public Lv_C_VO(String lv_type) {
		this.lv_type = lv_type;
	}

	public Lv_C_VO(int lv_cno, String lv_type) {
		this.lv_cno = lv_cno;
		this.lv_type = lv_type;
	}

	public int getLv_cno() {
		return lv_cno;
	}

	public void setLv_cno(int lv_cno) {
		this.lv_cno = lv_cno;
	}

	public String getLv_type() {
		return lv_type;
	}

	public void setLv_type(String lv_type) {
		this.lv_type = lv_type;
	}
	
	
}
