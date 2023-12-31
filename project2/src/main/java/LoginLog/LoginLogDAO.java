package LoginLog;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class LoginLogDAO {
private SqlSession sqlSession;
	
	public LoginLogDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int firstLog(LoginLogVO vo) {
		return sqlSession.insert("loginLog.firstLog",vo);
	}
	
	public int increFail(String userEmail) {
		return sqlSession.update("loginLog.increFail", userEmail);
	}
	
	public int statIn(Map<String, Object> map) {
		return sqlSession.update("loginLog.stat1", map);
	}
	
	public int statOut(int userId) {
		return sqlSession.update("loginLog.stat0", userId);
	}
	
	public LoginLogVO getLog(int userNo) {
		return sqlSession.selectOne("loginLog.getLog", userNo);
	}
}
