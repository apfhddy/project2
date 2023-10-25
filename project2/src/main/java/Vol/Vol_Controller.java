package Vol;
//package Vol;
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
//@RequestMapping("/vol")
//public class Vol_Controller implements ProjectPath{
//
//	private Member_Service memberService;
//	private Vol_Service vol_Service;
//
//	
//	public Vol_Controller(Member_Service memberService, Vol_Service vol_Service) {
//		this.memberService = memberService;
//		this.vol_Service = vol_Service;
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
//	    
//	    // 작성한 회원 번호 부여
//		//시퀀스값 부여
//		System.out.println("writeform \n" + no);
//		model.addAttribute("memberId", memberId);
//		//시퀀스값 뷰페이지로 전송
//		return VOL + "write.jsp";
//	}
//	
//	@RequestMapping("/write")
//	public String write(Model model, HttpSession session, Vol_VO vo) {
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
//	    vo.setMember_id(memberId);;
//	    // 작성한 회원 번호 부여
//	    int su = vol_Service.insert(vo);
//	    // 게시글 생성
//	    
//	    System.out.println("pf vo에 뭐가 들었니?" + vo.toString());
//	    
//	    model.addAttribute("su", su);
//	    model.addAttribute("no", no);
//	    model.addAttribute("status", "write");
//	    model.addAttribute("url", "/vol/content");
//	    // 뷰페이지로 전송
//	    return VOL + "result.jsp";
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
//		Vol_VO vo = vol_Service.selectOne(memberId);
//		
//		model.addAttribute("vo", vo);
//		
//		return VOL + "content.jsp";
//	}
//	
//	@RequestMapping("/updateForm")
//	public String updateForm(Model model,String memberId) {
//		Vol_VO vo = vol_Service.selectOne(memberId);
//		
//		model.addAttribute("vo", vo);
//		
//		return VOL + "update.jsp";
//	}
//	
//	@RequestMapping("/update")
//	public String update(Model model,Vol_VO vo) {
//		
//		int su = vol_Service.update(vo);
//		
//		model.addAttribute("su", su);
//		model.addAttribute("status", "update");
//		model.addAttribute("url", "/vol/content?no=" + vo.getVolNo());
//		
//		return VOL + "result.jsp";
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
