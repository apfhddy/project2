package Tech_Test_Certi;

import org.apache.ibatis.session.SqlSession;

public class Tech_Test_Certi_DAO {
	private SqlSession sqlsession;
	
	public Tech_Test_Certi_DAO(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
}
