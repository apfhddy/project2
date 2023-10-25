package Pretest_Opt;

public class Pretest_Opt_VO {
	
	private int pretest_opt_no;
	private String pretest_opt_id;
	private String pretest_q_no;
	private String opt;
	
	public Pretest_Opt_VO() {
		super();
	}
	
	
	// controller에서 ovo로 받아올거
	public Pretest_Opt_VO(String opt) {
		this.opt = opt;
	}

	public Pretest_Opt_VO(int pretest_opt_no, String pretest_opt_id, String pretest_q_no, String opt) {
		this.pretest_opt_no = pretest_opt_no;
		this.pretest_opt_id = pretest_opt_id;
		this.pretest_q_no = pretest_q_no;
		this.opt = opt;
	}

	public Pretest_Opt_VO(String pretest_opt_id, String pretest_q_no, String opt) {
		this.pretest_opt_id = pretest_opt_id;
		this.pretest_q_no = pretest_q_no;
		this.opt = opt;
	}

	
	
	public String getPretest_q_no() {
		return pretest_q_no;
	}

	public void setPretest_q_no(String pretest_q_no) {
		this.pretest_q_no = pretest_q_no;
	}

	public int getPretest_opt_no() {
		return pretest_opt_no;
	}

	public void setPretest_opt_no(int pretest_opt_no) {
		this.pretest_opt_no = pretest_opt_no;
	}

	public String getPretest_opt_id() {
		return pretest_opt_id;
	}

	public void setPretest_opt_no(String pretest_opt_id) {
		this.pretest_opt_id = pretest_opt_id;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	
	
}
