package Tech_Name_C;

import org.apache.ibatis.session.SqlSession;

public class Tech_Name_C_DAO {
	private SqlSession sqlsession;
	
	public Tech_Name_C_DAO(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
}
