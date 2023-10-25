package Relation;

public class Relation_VO {

	private int relation_no;
	private String relation; 
	
	public Relation_VO() {
		super();
	}

	public Relation_VO(int relation_no, String relation) {
		this.relation_no = relation_no;
		this.relation = relation;
	}
	
	public Relation_VO(String relation) {
		this.relation = relation;
	}

	public int getRelation_no() {
		return relation_no;
	}

	public void setRelation_no(int relation_no) {
		this.relation_no = relation_no;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
}
