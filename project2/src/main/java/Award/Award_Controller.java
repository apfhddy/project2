package Award;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Member.Member_Service;
import path.ProjectPath;


@Controller
@RequestMapping("/award")
public class Award_Controller implements ProjectPath{

	private Member_Service memberService;
	private Award_Service awardService;

	
	public Award_Controller(Member_Service memberService, Award_Service awardService) {
		this.memberService = memberService;
		this.awardService = awardService;
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
		System.out.println("writeform \n" + no);
		model.addAttribute("memberId", memberId);
		//시퀀스값 뷰페이지로 전송
		return AWARD + "write.jsp";
	}
	
	@RequestMapping("/write")
	public String write(Model model, HttpSession session, Award_VO vo) {
	    System.out.println("write 서비스에는 접근?");
	    
	    // 로그인 상태 확인
	    Integer no = (Integer) session.getAttribute("login");
	    if (no == null) {
	        return "redirect:/login/loginform";
	    }
	    
	    String memberId = memberService.seleceUserId(no);
	    
	    vo.setMemberId(memberId);
	    
	    int su = awardService.insert(vo);
	    // 게시글 생성
	    
	    System.out.println("pf vo에 뭐가 들었니?" + vo.toString());
	    
	    model.addAttribute("su", su);
	    model.addAttribute("memberId", memberId);
	    model.addAttribute("status", "write");
	    model.addAttribute("url", "/award/content");
	    // 뷰페이지로 전송
	    return AWARD + "result.jsp";
	}
	
	
	@RequestMapping("/content")
	public String content(Model model,HttpSession session) {
	    // 로그인 상태 확인
	    Integer no = (Integer) session.getAttribute("login");
	    if (no == null) {
	        return "redirect:/login/loginform";
	    }
	    
	    String memberId = memberService.seleceUserId(no);
	    
		System.out.println("content 진입" + no);

		Award_VO vo = awardService.selectOne(memberId);
		
		model.addAttribute("vo", vo);
		
		return AWARD + "content.jsp";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(Model model,String memberId) {
		Award_VO vo = awardService.selectOne(memberId);
		
		model.addAttribute("vo", vo);
		model.addAttribute("memberId", memberId);
		
		return AWARD + "update.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Model model,Award_VO vo) {
		
		int su = awardService.update(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "update");
		model.addAttribute("url", "/award/content?no=" + vo.getAwardNo());
		
		return AWARD + "result.jsp";
		
	}
	
}



















