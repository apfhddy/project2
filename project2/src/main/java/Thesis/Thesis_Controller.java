package Thesis;
//package Thesis;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import Member.Member_Service;
//import path.ProjectPath;
//
//
//@Controller
//@RequestMapping("/thesis")
//public class Thesis_Controller implements ProjectPath{
//
//	private Member_Service memberService;
//	private Thesis_Service thesis_Service;
//
//	
//	public Thesis_Controller(Member_Service memberService, Thesis_Service thesis_Service) {
//		this.memberService = memberService;
//		this.thesis_Service = thesis_Service;
//	}
//	
//	@RequestMapping("/writeForm")
//	public String writeForm(Model model, HttpSession session) {
//	    
//	    // 로그인 상태 확인
//	    Integer no = (Integer) session.getAttribute("login");
//	    if (no == null) {
//	        return "redirect:/login/loginform";
//	    }
//	    
//	    String memberId = memberService.seleceUserId(no);
//		//시퀀스값 부여
//		System.out.println("writeform \n" + no);
//		model.addAttribute("memberId", memberId);
//		//시퀀스값 뷰페이지로 전송
//		return THESIS+ "write.jsp";
//	}
//	
//	@RequestMapping("/write")
//	public String write(Model model, HttpSession session, Thesis_VO vo) {
//	    System.out.println("write 서비스에는 접근?");
//	    
//	    // 로그인 상태 확인
//	    Integer no = (Integer) session.getAttribute("login");
//	    if (no == null) {
//	        return "redirect:/login/loginform";
//	    }
//	    
//	    String memberId = memberService.seleceUserId(no);
//	    
//	    vo.setMemberId(memberId);
//	    // 작성한 회원 번호 부여
//	    int su = thesis_Service.insert(vo);
//	    // 게시글 생성
//	    
//	    System.out.println("pf vo에 뭐가 들었니?" + vo.toString());
//	    
//	    model.addAttribute("su", su);
//	    model.addAttribute("memberId", memberId);
//	    model.addAttribute("status", "write");
//	    model.addAttribute("url", "/thesis/content");
//	    // 뷰페이지로 전송
//	    return THESIS+ "result.jsp";
//	}
//	
//	
//	@RequestMapping("/content")
//	public String content(Model model,HttpSession session) {
//	    // 로그인 상태 확인
//	    Integer no = (Integer) session.getAttribute("login");
//	    if (no == null) {
//	        return "redirect:/login/loginform";
//	    }	   
//	    
//	    String memberId = memberService.seleceUserId(no);
//	    
//		System.out.println("content 진입" + no);
//
//		Thesis_VO vo = thesis_Service.selectOne(memberId);
//		
//		model.addAttribute("vo", vo);
//		
//		return THESIS+ "content.jsp";
//	}
//	
//	@RequestMapping("/updateForm")
//	public String updateForm(Model model,String memberId) {
//		Thesis_VO vo = thesis_Service.selectOne(memberId);
//		
//		model.addAttribute("vo", vo);
//		
//		return THESIS+ "update.jsp";
//	}
//	
//	@RequestMapping("/update")
//	public String update(Model model,Thesis_VO vo) {
//		
//		int su = thesis_Service.update(vo);
//		
//		model.addAttribute("su", su);
//		model.addAttribute("status", "update");
//		model.addAttribute("url", "/pf/content?no=" + vo.getThesisNo());
//		
//		return THESIS+ "result.jsp";
//		
//	}
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
