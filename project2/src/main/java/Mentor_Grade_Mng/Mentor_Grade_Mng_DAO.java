package Mentor_Grade_Mng;

import org.apache.ibatis.session.SqlSession;

public class Mentor_Grade_Mng_DAO {
	private SqlSession sqlsession;
	
	public Mentor_Grade_Mng_DAO(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
}
