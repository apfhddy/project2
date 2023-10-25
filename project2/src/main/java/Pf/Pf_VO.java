package Pf;

import java.sql.Date;

public class Pf_VO {
	private int no;
	private int pfNo;
	private String memberId;
	private String bgImg;
	private String mainImg;
	private int hit;
	private Date updated;
	private String content;
	private String nickname;
	private String posi;
	
	
	public Pf_VO() {
		super();
	}


	public Pf_VO(int no, int pfNo, String memberId, String bgImg, String mainImg, int hit, Date updated, String content,
			String nickname, String posi) {
		super();
		this.no = no;
		this.pfNo = pfNo;
		this.memberId = memberId;
		this.bgImg = bgImg;
		this.mainImg = mainImg;
		this.hit = hit;
		this.updated = updated;
		this.content = content;
		this.nickname = nickname;
		this.posi = posi;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
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


	public String getBgImg() {
		return bgImg;
	}


	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}


	public String getMainImg() {
		return mainImg;
	}


	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public Date getUpdated() {
		return updated;
	}


	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getPosi() {
		return posi;
	}


	public void setPosi(String posi) {
		this.posi = posi;
	}


	@Override
	public String toString() {
		return "PfVO [no=" + no + ", pfNo=" + pfNo + ", memberId=" + memberId + ", bgImg=" + bgImg + ", mainImg="
				+ mainImg + ", hit=" + hit + ", updated=" + updated + ", content=" + content + ", nickname=" + nickname
				+ ", posi=" + posi + "]";
	}

}