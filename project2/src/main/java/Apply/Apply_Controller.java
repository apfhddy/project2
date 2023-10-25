package Apply;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Apply_Form.Apply_Form_Service;
import Apply_Form.Apply_Form_VO;
import Apply_List.Apply_List_Service;
import Apply_Mng.Apply_Mng_Service;
import Apply_Mng.Apply_Mng_VO;
import Apply_Stat.Apply_Stat_Service;
import Jpost.Jpost_Service;
import path.Encry;
import path.ProjectPath;

@Controller
public class Apply_Controller implements ProjectPath{

	private Apply_Service apply_service;
	private Apply_Form_Service apply_form_service;
	private Apply_List_Service apply_list_service;
	private Apply_Stat_Service apply_stat_service;
	private Apply_Mng_Service apply_mng_service;
	private Jpost_Service jpost_service;
	
	public Apply_Controller(Apply_Service apply_service, Apply_Form_Service apply_form_service, Apply_List_Service apply_list_service, Apply_Stat_Service apply_stat_service, Apply_Mng_Service apply_mng_service, Jpost_Service jpost_service) {
		this.apply_service = apply_service;
		this.apply_form_service = apply_form_service;
		this.apply_list_service = apply_list_service;
		this.apply_stat_service = apply_stat_service;
		this.apply_mng_service = apply_mng_service;
		this.jpost_service = jpost_service;
	}
	
	
	@RequestMapping("/apply/writeform")
	public String writeform(Model model) {
		
		return APPLY + "write.jsp";
	}
	
	@RequestMapping("/apply/write")
	public String write(HttpServletRequest request) {
		
		// Apply_Form 테이블 칼럼
		String apply_form_id = Encry.getUUID("AAPF");
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		
		Apply_Form_VO fvo = new Apply_Form_VO(apply_form_id, title, detail);

		// mapper에 저장
		apply_form_service.insert(fvo);
		
		// 데이터 보내기
		request.setAttribute("status", "write");
		request.setAttribute("url","/apply/list");
		
		return APPLY + "result.jsp"; 
	}

	@RequestMapping("/apply/list")
	public String list(Model model) {
		
		List<Map<String, Object>> apply_vo = apply_service.apply_vo();
		
		model.addAttribute("apply_vo", apply_vo);
		
		return APPLY + "list.jsp";
	}

	@RequestMapping("/apply/submitform")
	public String submitform(Model model, String no) {
		
		System.out.println("apply/submitform no = " + no);
		
		List<Map<String, Object>> apply_vo = apply_service.apply_vo();	// 유저가 작성한 지원서들 효출
//		Map<String,Object> map = jpost_service.getContent(no);			// 제출할 지원서

		//model.addAttribute("no", no);
//		model.addAttribute("map", map);
		model.addAttribute("apply_vo", apply_vo);
		model.addAttribute("url", "/clilnk/apply/submit?no=" + no);

		System.out.println("apply/submitform 에서 no = " + no);
		System.out.println("apply/submitform 에서 apply_vo = " + apply_vo);

		return APPLY + "submit.jsp";
	}
	
	@RequestMapping("/apply/submit")
	public String submit(Model model, Apply_Mng_VO vo, String no) {

		System.out.println("apply/submit 에서 no = " + no);
		
		vo.setApply_mng_id(Encry.getUUID("APMX"));
		
		int su = apply_mng_service.insert(vo);
		
		System.out.println("apply/submit 에서 mng insert 완료");
		
		model.addAttribute("su", su);
		model.addAttribute("status", "submit");
		model.addAttribute("url", "/clink/apply/complete");
		
		return APPLY + "result.jsp";
	}
	
	// jpost_id 를 no 로 넘기는 방법
	// 1. session 에 jpost_id를 담아서 넘기기 >> 사용자 행동 변수가 너무 많음
	// 2. no 만 억지로 넘기기
	// 3. 한 페이지에서 처리하기	>> 제일 깔끔   
	
	
	@RequestMapping("/apply/complete")
	public String complete(Model model) {
		return APPLY + "";
	}
	@RequestMapping("/apply/content")
	public String getContent(HttpServletRequest request, String no) {
		
		List<Map<String, Object>> apply_all_vo = apply_service.apply_all_vo(no);
		
		request.setAttribute("apply_all_vo", apply_all_vo);
		
		//System.out.println(apply_all_vo.get(0).get("GENDER") instanceof String);	// 오류 확인 코드

		return APPLY + "content.jsp";
	}
	
	@RequestMapping("/apply/updateform")
	public String updateform(HttpServletRequest request, String no) {
		
		System.out.println("/apply/updateform 시작");
		
		// DB에 저장된 데이터 불러오기
		Map<String, Object> map	= apply_service.getContent(no);
//		List<Map<String, Object>> apply_all_vo = apply_service.apply_all_vo(no);
		
		// 데이터 보내기
		request.setAttribute("vo", map);
//		request.setAttribute("apply_all_vo", apply_all_vo);
		
		return APPLY + "update.jsp";
	}
	
	@RequestMapping("/apply/update")
	public String update(HttpServletRequest request, String no) {
		
		// 수정된 데이터를 저장할 칼럼
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		
		
		// Join할 테이블의 생성자 (수정된 데이터가 들어갈 칼럼 기입)
		// - int는 Integer로 형변환
		Apply_VO avo = new Apply_VO();
		Apply_Form_VO fvo = new Apply_Form_VO(title, detail);
		
		
		// DB에 수정된 내용 저장
		apply_service.update(avo);
		apply_form_service.update(fvo);
		
		request.setAttribute("status", "update");
		request.setAttribute("url", "/clink/jpost/content?no=" + avo.getApply_id());
		
		return APPLY + "result.jsp";
	}
	
	
	@RequestMapping("/apply/hidden")
	public String hidden(HttpServletRequest request, String no) {
		
		apply_service.hidden(no);
		
		request.setAttribute("status", "hidden");
		request.setAttribute("url","/clink/apply/list");
		
		return APPLY + "result.jsp";
	}
	
	
}
