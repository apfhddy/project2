package Exam;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Member.Member_Service;
import path.ProjectPath;


@Controller
@RequestMapping("/exam")
public class Exam_Controller implements ProjectPath{

	private Member_Service memberService;
	private Exam_Service exam_Service;

	
	public Exam_Controller(Member_Service memberService, Exam_Service exam_Service) {
		this.memberService = memberService;
		this.exam_Service = exam_Service;
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
		return EXAM + "write.jsp";
	}
	
	@RequestMapping("/write")
	public String write(Model model, HttpSession session, Exam_VO vo) {
	    System.out.println("write 서비스에는 접근?");
	    
	    // 로그인 상태 확인
	    Integer no = (Integer) session.getAttribute("login");
	    if (no == null) {
	        return "redirect:/login/loginform";
	    }
	    
	    String memberId = memberService.seleceUserId(no);
	    
	    vo.setMemberId(memberId);
	    // 작성한 회원 번호 부여
	    int su = exam_Service.insert(vo);
	    // 게시글 생성
	    
	    System.out.println("pf vo에 뭐가 들었니?" + vo.toString());
	    
	    model.addAttribute("su", su);
	    model.addAttribute("memberId", memberId);
	    model.addAttribute("status", "write");
	    model.addAttribute("url", "/exam/content");
	    // 뷰페이지로 전송
	    return EXAM + "result.jsp";
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

		Exam_VO vo = exam_Service.selectOne(memberId);
		
		model.addAttribute("vo", vo);
		
		return EXAM + "content.jsp";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(Model model,String memberId) {
		Exam_VO vo = exam_Service.selectOne(memberId);
		
		model.addAttribute("vo", vo);
		model.addAttribute("memberId", memberId);
		
		return EXAM + "update.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Model model,Exam_VO vo, String memberId) {
		
		int su = exam_Service.update(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "update");
		model.addAttribute("url", "/exam/content?no=" + vo.getExamNo());
		
		return EXAM + "result.jsp";
		
	}
	
}



















