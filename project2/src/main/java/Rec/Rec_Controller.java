package Rec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Rec_Ask.Rec_Ask_Service;
import Rec_Ask.Rec_Ask_VO;
import Rec_Form.Rec_Form_Service;
import Rec_Form.Rec_Form_VO;
import Relation.Relation_Service;
import Relation.Relation_VO;
import path.ProjectPath;

@Controller
public class Rec_Controller implements ProjectPath{

	private Rec_Form_Service rec_form_service; 
	private Rec_Ask_Service rec_ask_service; 
	private Relation_Service relation_service;
	
	public Rec_Controller(Rec_Form_Service rec_form_service, Rec_Ask_Service rec_ask_service, Relation_Service relation_service) {
		this.rec_form_service = rec_form_service;
		this.rec_ask_service = rec_ask_service;
		this.relation_service = relation_service;
	}

	
	// WRITE ====================================================================================================================
	@RequestMapping("/recommand/ask_writeform")
	public String ask_writeform(Model model) {
		
		// 타 테이블 데이터 불러오기
		// - DB에 insert문으로 넣었으면 commit 하는 습관
		List<Relation_VO> rlist = relation_service.selectList();
		
		model.addAttribute("rlist", rlist);

		return RECOMMAND + "/ask/write.jsp";
	}

	@RequestMapping("/recommand/ask_write")
	public String ask_write(Model model, Rec_Ask_VO vo) {
		
		int su = rec_ask_service.insert(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "request");
		model.addAttribute("url", "/clink/recommand/ask_list");
		
		return RECOMMAND + "result.jsp";
	}
	
	@RequestMapping("/recommand/form_writeform")
	public String form_write(Model model, String no) {
		
		// 타 테이블 데이터 불러오기
		// - rec_ask 의 특정 데이터 가져오기
		Map<String, Object> content = rec_ask_service.content(no);
		
		model.addAttribute("ask_list", content);
		
		return RECOMMAND + "/form/write.jsp";
	}
	
	@RequestMapping("/recommand/form_write")
	public String form_write(Model model, Rec_Form_VO vo) {
		
		int su = rec_form_service.insert(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "write");
		model.addAttribute("url", "/clink/recommand/form_list");
		
		return RECOMMAND + "result.jsp";
	}
	
	// UPDATE ===================================================================================================================
	@RequestMapping("/recommand/ask_updateform")
	public String ask_updateform(Model model, String no) {
		
		Map<String, Object> content = rec_ask_service.content(no);
		List<Relation_VO> rlist = relation_service.selectList();

		System.out.println("ask_updateform 에서 no = " + no);
		System.out.println("ask_updateform 에서 content = " + content);
		
		model.addAttribute("vo", content);
		model.addAttribute("rlist", rlist);
		
		return RECOMMAND + "/ask/update.jsp";
	}

	@RequestMapping("/recommand/ask_update")
	public String ask_update(Model model, Rec_Ask_VO vo) {
		
		int su = rec_ask_service.update(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "update");
		model.addAttribute("url", "/clink/recommand/ask_list");
		
		System.out.println("ask_update 에서 model = " + model);
		System.out.println("ask_update 에서 vo = " + vo);
		
		return RECOMMAND + "result.jsp";
	}
	
	@RequestMapping("/recommand/form_updateform")
	public String form_updateform(Model model, String no) {
		
		Map<String, Object> content = rec_form_service.content(no);
		
		model.addAttribute("vo", content);
		
		System.out.println("form_updateform 에서 content = " + content);
		System.out.println("form_updateform 에서 no = " + no);
		
		return RECOMMAND + "/form/update.jsp";
	}
	
	
	@RequestMapping("/recommand/form_update")
	public String form_update(Model model, Rec_Form_VO vo) {
		
		int su = rec_form_service.update(vo);
		
		System.out.println("form_update 에서 vo.getRec_form_id() = " + vo.getRec_form_id());
		System.out.println("form_update 에서 vo.getRec_form_id() = " + vo.getDetail());
		System.out.println("form_update 에서 rec_form_service.update(vo) = " + rec_form_service.update(vo));
		
		model.addAttribute("su", su);
		model.addAttribute("status", "update");
		model.addAttribute("url", "/clink/recommand/form_list");
		
		return RECOMMAND + "result.jsp";
	}
	
	
	// LIST =====================================================================================================================
	@RequestMapping("/recommand/ask_list")
	public String ask_list(Model model) {
	
		// 추천서 작성 요청 리스트
		List<Map<String, Object>> rec_ask_vo = rec_ask_service.rec_ask_vo();
		
		// 추천서 작성 완료 리스트
		List<Map<String, Object>> rec_form_vo = rec_form_service.rec_form_vo();
		
		System.out.println("ask_list 에서 rec_ask_vo = " + rec_ask_vo);
		System.out.println("ask_list 에서 rec_form_vo = " + rec_form_vo);
		
		model.addAttribute("alist", rec_ask_vo);
		model.addAttribute("flist", rec_form_vo);
	
		return RECOMMAND + "/ask/list.jsp";
	}
	
	@RequestMapping("/recommand/form_list")
	public String form_list(Model model, String no) {
		
		// 추천서 작성 대기 리스트
		List<Map<String, Object>> rec_ask_vo = rec_ask_service.rec_ask_vo();
		
		// 추천서 작성 완료 리스트
		List<Map<String, Object>> rec_form_vo = rec_form_service.rec_form_vo();
		
		model.addAttribute("alist", rec_ask_vo);
		model.addAttribute("flist", rec_form_vo);
		
		return RECOMMAND + "/form/list.jsp";
	}
	
	
	// CONTENT =====================================================================================================================
	@RequestMapping("/recommand/ask_content")
	public String ask_content(Model model, String no) {
		
		Map<String, Object> content = rec_ask_service.content(no);
		
		System.out.println("ask_content 에서 content = " + content);
		
		model.addAttribute("vo", content);
		
		return RECOMMAND + "/ask/content.jsp";
	}
	
	@RequestMapping("/recommand/form_content")
	public String form_content(Model model, String no) {
		
		Map<String, Object> content = rec_form_service.content(no);
		
		System.out.println("form_content 에서 content = " + content);
		
		model.addAttribute("vo", content);
		
		return RECOMMAND + "/form/content.jsp";
	}
	
	// DELETE =====================================================================================================================
	@RequestMapping("/recommand/ask_delete")
	public String ask_delete(Model model, String no) {
		
		int su = rec_ask_service.delete(no);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "delete");
		model.addAttribute("url", "/clink/recommand/ask_list");
		
		return RECOMMAND + "result.jsp";
	}
	
	@RequestMapping("/recommand/form_delete")
	public String form_delete(Model model, String no) {
		
		int su = rec_form_service.delete(no);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "delete");
		model.addAttribute("url", "/clink/recommand/form_list");
		
		return RECOMMAND + "result.jsp";
	}
	
}


