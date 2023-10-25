package Exam;

import java.sql.Date;

public class Exam_VO {
	private int examNo;
	private int pfNo;
	private String memberId;
	private String jareaCno;
	private int legi;
	private String name;
	private int score;
	private int lv;
	private Date examDate;
	private String detail;
	
	
	public Exam_VO() {
		super();
	}


	public Exam_VO(int examNo, int pfNo, String memberId, String jareaCno, int legi, String name, int score, int lv,
			Date examDate, String detail) {
		super();
		this.examNo = examNo;
		this.pfNo = pfNo;
		this.memberId = memberId;
		this.jareaCno = jareaCno;
		this.legi = legi;
		this.name = name;
		this.score = score;
		this.lv = lv;
		this.examDate = examDate;
		this.detail = detail;
	}


	public int getExamNo() {
		return examNo;
	}


	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}


	public int getPfNo() {
		return pfNo;
	}


	public void setPfNo(int pfNo) {
		this.pfNo = pfNo;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getJareaCno() {
		return jareaCno;
	}


	public void setJareaCno(String jareaCno) {
		this.jareaCno = jareaCno;
	}


	public int getLegi() {
		return legi;
	}


	public void setLegi(int legi) {
		this.legi = legi;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getLv() {
		return lv;
	}


	public void setLv(int lv) {
		this.lv = lv;
	}


	public Date getExamDate() {
		return examDate;
	}


	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Override
	public String toString() {
		return "ExamVO [examNo=" + examNo + ", pfNo=" + pfNo + ", jareaCno=" + jareaCno + ", legi=" + legi + ", name="
				+ name + ", score=" + score + ", lv=" + lv + ", examDate=" + examDate + ", detail=" + detail + "]";
	}

}