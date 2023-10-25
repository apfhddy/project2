//package LoginLog;
//
//import java.util.Map;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import Member.Member_DAO;
//import Member.Member_DTO;
//import path.Encry;
//
//public class LoginService implements UserDetailsService{
//
//	private Member_DAO member_dao;
//	private LoginLogDAO loginLogDAO;
//	private PasswordEncoder passwordEncoder;
//	
//	public LoginService(Member_DAO member_dao, LoginLogDAO loginLogDAO) {
//		this.member_dao = member_dao;
//		this.loginLogDAO = loginLogDAO;
//	}
//	
//	public int insert(Member_DTO vo) {
//		String salt = Encry.getSalt();
//		vo.setSalt(salt);
//		
//		String password = vo.getSecret_pw();
//		password = passwordEncoder.encode(password);
//		
//		vo.setSecret_pw(password);
//		return member_dao.insert(vo);
//	}
//	
//	public String getSalt(String email) {
//		return member_dao.getSalt(email);
//	}
//	
//	public Map<String, Object> login(Member_DTO userVO) {
//		return member_dao.login(userVO);
//	}
//	
//	public int nextSeq() {
//		return member_dao.nextSeq();
//	}
//	
//	public int firstLog(LoginLogVO vo) {
//		return loginLogDAO.firstLog(vo);
//	}
//	
//	public int increFail(String userEmail) {
//		return loginLogDAO.increFail(userEmail);
//	}
//	
//	public int statIn(Map<String, Object> map) {
//		return loginLogDAO.statIn(map);
//	}
//	
//	public int statOut(int userId) {
//		return loginLogDAO.statOut(userId);
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		Member_DTO user = member_dao.getUser(username);
//		
//		if(user == null) {
//			throw new UsernameNotFoundException("User not found: " + username);
//		}
//		return null; //new Member_DTO(user.getUserId(), user.getUserEmail(), user.getUserPassword(), user.getUserStatus(),user.getAuthorities());
//	}
//	
//	public PasswordEncoder getPasswordEncoder() {
//		return passwordEncoder;
//	}
//
//	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}
//	
//	public LoginLogVO getLog(int userNo) {
//		return this.loginLogDAO.getLog(userNo);
//	}
//}
