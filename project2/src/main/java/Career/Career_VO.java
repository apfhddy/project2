package Career;

import java.sql.Date;

public class Career_VO {

	private String career_no;
	private String pf_no;
	private String member_no;
	private String company;
	private String posi;
	private String task;
	private int empl_type_cno;
	private int city_cno;
	private int stat;
	private int jarea_cno;
	private Date start_date;
	private Date end_date;
	
	
	public Career_VO() {
		super();
	}

	
	public Career_VO(String company, String posi, String task, int empl_type_cno, int city_cno, int stat, int jarea_cno, Date start_date, Date end_date) {
		this.company = company;
		this.posi = posi;
		this.task = task;
		this.empl_type_cno = empl_type_cno;
		this.city_cno = city_cno;
		this.stat = stat;
		this.jarea_cno = jarea_cno;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Career_VO(String career_no, String pf_no, String member_no, String company, String posi, String task, int empl_type_cno, int city_cno, int stat, int jarea_cno, Date start_date, Date end_date) {
		this.career_no = career_no;
		this.pf_no = pf_no;
		this.member_no = member_no;
		this.company = company;
		this.posi = posi;
		this.task = task;
		this.empl_type_cno = empl_type_cno;
		this.city_cno = city_cno;
		this.stat = stat;
		this.jarea_cno = jarea_cno;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public String getCareer_no() {
		return career_no;
	}

	public void setCareer_no(String career_no) {
		this.career_no = career_no;
	}

	public String getPf_no() {
		return pf_no;
	}

	public void setPf_no(String pf_no) {
		this.pf_no = pf_no;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosi() {
		return posi;
	}

	public void setPosi(String posi) {
		this.posi = posi;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getEmpl_type_cno() {
		return empl_type_cno;
	}

	public void setEmpl_type_cno(int empl_type_cno) {
		this.empl_type_cno = empl_type_cno;
	}

	public int getCity_cno() {
		return city_cno;
	}

	public void setCity_cno(int city_cno) {
		this.city_cno = city_cno;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public int getJarea_cno() {
		return jarea_cno;
	}

	public void setJarea_cno(int jarea_cno) {
		this.jarea_cno = jarea_cno;
	}
	
	
	
}
