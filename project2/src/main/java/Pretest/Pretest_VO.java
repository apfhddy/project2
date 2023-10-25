package Pretest;

public class Pretest_VO {

	private int pretest_no;
	private String pretest_id;
	private String jpost_id;
	private int classify;
	private int stat;
	
	public Pretest_VO() {
		super();
	}

	// controller에서 pvo로 받아올거
	public Pretest_VO(int classify) {
		this.classify = classify;
	}

	public Pretest_VO(String pretest_id, int classify, String jpost_id, int stat) {
		this.pretest_id = pretest_id;
		this.classify = classify;
		this.jpost_id = jpost_id;
		this.stat=stat;
	}

	public Pretest_VO(int pretest_no, String pretest_id, int classify, String jpost_id, int stat) {
		this.pretest_no = pretest_no;
		this.pretest_id = pretest_id;
		this.classify = classify;
		this.jpost_id = jpost_id;
		this.stat = stat;
	}

	
	
	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public int getPretest_no() {
		return pretest_no;
	}

	public void setPretest_no(int pretest_no) {
		this.pretest_no = pretest_no;
	}

	public String getPretest_id() {
		return pretest_id;
	}

	public void setPretest_id(String pretest_id) {
		this.pretest_id = pretest_id;
	}

	public int getClassify() {
		return classify;
	}

	public void setClassify(int classify) {
		this.classify = classify;
	}

	public String getJpost_id() {
		return jpost_id;
	}

	public void setJpost_id(String jpost_id) {
		this.jpost_id = jpost_id;
	}

	
	
}
