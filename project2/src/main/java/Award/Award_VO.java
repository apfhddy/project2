package Award;

import java.sql.Date;

public class Award_VO {
	private int awardNo;
	private int pfNo;
	private String memberId;
	private String name;
	private String author;
	private Date awardDate;
	private String detail;
	
	public Award_VO() {
		super();
	}

	public Award_VO(int awardNo, int pfNo, String memberId, String name, String author, Date awardDate, String detail) {
		super();
		this.awardNo = awardNo;
		this.pfNo = pfNo;
		this.memberId = memberId;
		this.name = name;
		this.author = author;
		this.awardDate = awardDate;
		this.detail = detail;
	}

	public int getAwardNo() {
		return awardNo;
	}

	public void setAwardNo(int awardNo) {
		this.awardNo = awardNo;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getAwardDate() {
		return awardDate;
	}

	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "AwardVO [awardNo=" + awardNo + ", pfNo=" + pfNo + ", memberId=" + memberId + ", name=" + name
				+ ", author=" + author + ", awardDate=" + awardDate + ", detail=" + detail + "]";
	}

}