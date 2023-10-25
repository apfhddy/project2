package Pretest_Q;

public class Pretest_Q_VO {

	private int pretest_q_no;
	private String pretest_q_id;
	private String pretest_no;
	private String question;
	
	public Pretest_Q_VO() {
		super();
	}

	// controller에서 qvo로 받아올거
	public Pretest_Q_VO(String question) {
		this.question = question;
	}

	public Pretest_Q_VO(int pretest_q_no, String pretest_q_id, String pretest_no, String question) {
		this.pretest_q_no = pretest_q_no;
		this.pretest_q_id = pretest_q_id;
		this.pretest_no = pretest_no;
		this.question = question;
	}

	public Pretest_Q_VO(String pretest_q_id, String pretest_no, String question) {
		this.pretest_q_id = pretest_q_id;
		this.pretest_no = pretest_no;
		this.question = question;
	}

	public int getPretest_q_no() {
		return pretest_q_no;
	}

	public void setPretest_q_no(int pretest_q_no) {
		this.pretest_q_no = pretest_q_no;
	}

	public String getPretest_q_id() {
		return pretest_q_id;
	}

	public void setPretest_q_id(String pretest_q_id) {
		this.pretest_q_id = pretest_q_id;
	}

	public String getPretest_no() {
		return pretest_no;
	}

	public void setPretest_no(String pretest_no) {
		this.pretest_no = pretest_no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
	
	
}
