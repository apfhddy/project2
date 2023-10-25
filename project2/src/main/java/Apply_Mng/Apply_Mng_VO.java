package Apply_Mng;

public class Apply_Mng_VO {

	private int apply_no;
	private String apply_mng_id;
	private String jpost_id;
	private String apply_id;
	private int fit;
	
	// 디폴트 생성자
	public Apply_Mng_VO() {
		super();
	}

	// Controller에서 받아야하는 데이터 생성자 
	public Apply_Mng_VO(String apply_mng_id, String jpost_id, String apply_id, int fit) {
		this.apply_mng_id = apply_mng_id;
		this.jpost_id = jpost_id;
		this.apply_id = apply_id;
		this.fit = fit;
	}

	public Apply_Mng_VO(int apply_no, String apply_mng_id, String jpost_id, String apply_id, int fit) {
		this.apply_no = apply_no;
		this.apply_mng_id = apply_mng_id;
		this.jpost_id = jpost_id;
		this.apply_id = apply_id;
		this.fit = fit;
	}

	public int getApply_no() {
		return apply_no;
	}

	public void setApply_no(int apply_no) {
		this.apply_no = apply_no;
	}

	public String getApply_mng_id() {
		return apply_mng_id;
	}

	public void setApply_mng_id(String apply_mng_id) {
		this.apply_mng_id = apply_mng_id;
	}

	public String getJpost_id() {
		return jpost_id;
	}

	public void setJpost_id(String jpost_id) {
		this.jpost_id = jpost_id;
	}

	public String getApply_id() {
		return apply_id;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public int getFit() {
		return fit;
	}

	public void setFit(int fit) {
		this.fit = fit;
	}
	
	
	
	
	
}
