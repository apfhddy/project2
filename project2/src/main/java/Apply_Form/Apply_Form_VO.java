package Apply_Form;

public class Apply_Form_VO {

	private int no;
	private String apply_form_id;
	private String title;
	private String detail;
	
	public Apply_Form_VO() {
		super();
	}

	public Apply_Form_VO(int no, String apply_form_id, String title, String detail) {
		this.no = no;
		this.apply_form_id = apply_form_id;
		this.title = title;
		this.detail = detail;
	}

	public Apply_Form_VO(String apply_form_id, String title, String detail) {
		this.apply_form_id = apply_form_id;
		this.title = title;
		this.detail = detail;
	}

	public Apply_Form_VO(String title, String detail) {
		this.title = title;
		this.detail = detail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


	public String getApply_form_id() {
		return apply_form_id;
	}

	public void setApply_form_id(String apply_form_id) {
		this.apply_form_id = apply_form_id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}	
	
	
	
}
