package Pf;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Member.Member_Service;
import path.ProjectPath;


@Controller
public class Pf_Controller implements ProjectPath{

	private Member_Service memberService;
	private Pf_Service pf_Service;

	
	public Pf_Controller(Member_Service memberService, Pf_Service pf_Service) {
		this.memberService = memberService;
		this.pf_Service = pf_Service;
	}
	
	@RequestMapping("ppfList")
	public String pfList() {
		return PF + "pfList.jsp";
	}
	
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model, HttpSession session) {
	    
	    // 로그인 상태 확인
	    Integer no = (Integer) session.getAttribute("login");
	    if (no == null) {
	        return "redirect:/login/loginform";
	    }
	    
	    String memberId = memberService.seleceUserId(no);
	    
		//시퀀스값 부여
		System.out.println("writeform \n" + memberId);
		model.addAttribute("memberId", memberId);
		//시퀀스값 뷰페이지로 전송
		return PF + "write.jsp";
	}
	
	@RequestMapping("/write")
	public String write(Model model, HttpSession session, Pf_VO vo) {
	    System.out.println("write 서비스에는 접근?");
	    
	    // 로그인 상태 확인
	    Integer no = (Integer) session.getAttribute("login");
	    if (no == null) {
	        return "redirect:/login/loginform";
	    }
	    
	    String memberId = memberService.seleceUserId(no);
	    
	    vo.setMemberId(memberId);
	    
	    int su = pf_Service.insert(vo);
	    
	    // 게시글 생성
	    
	    System.out.println("pf vo에 뭐가 들었니?" + vo.toString());
	    
	    model.addAttribute("su", su);
	    model.addAttribute("memberId", memberId);
	    model.addAttribute("status", "write");
	    model.addAttribute("url", "/pf/content");
	    // 뷰페이지로 전송
	    return PF + "result.jsp";
	}
	
	
	@RequestMapping("/content")
	public String content(Model model,HttpSession session, String memberId) {
	    // 로그인 상태 확인
	    Integer no = (Integer) session.getAttribute("login");
	    if (no == null) {
	        return "redirect:/login/loginform";
	    }
	    
		System.out.println("content 진입" + no);

		Pf_VO vo = pf_Service.selectOne(memberId);
		
		model.addAttribute("vo", vo);
		
		return PF + "content.jsp";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(Model model,String memberId) {
		Pf_VO vo = pf_Service.selectOne(memberId);
		
		model.addAttribute("vo", vo);
		
		return PF + "update.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Model model,Pf_VO vo) {
		
		int su = pf_Service.update(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "update");
		model.addAttribute("url", "/pf/content?no=" + vo.getNo());
		
		return PF + "result.jsp";
		
	}
	
}



















