package Pretest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pretest_Opt.Pretest_Opt_Service;
import Pretest_Opt.Pretest_Opt_VO;
import Pretest_Q.Pretest_Q_Service;
import Pretest_Q.Pretest_Q_VO;
import path.ProjectPath;

@Controller
public class Pretest_Controller implements ProjectPath{
	
	private Pretest_Service pretest_service;
	private Pretest_Q_Service pretest_q_service;
	private Pretest_Opt_Service pretest_opt_service;
	
	public Pretest_Controller(Pretest_Service pretest_service, Pretest_Q_Service pretest_q_service, Pretest_Opt_Service pretest_opt_service) {
		this.pretest_service = pretest_service;
		this.pretest_q_service = pretest_q_service;
		this.pretest_opt_service = pretest_opt_service;
	}
	
	@RequestMapping("/pretest/list")
	public String list(Model model) {
		
		List<Map<String, Object>> pretest_all_vo = pretest_service.pretest_all_vo();
		
		model.addAttribute("pretest_all_vo", pretest_all_vo);

		return PRETEST + "list.jsp";
	}
	
	@RequestMapping("/pretest/pre_pretest/")
	public String write(Model model, int no){

		List<Map<String, Object>> pre_pretest = new ArrayList<>();
		List<Pretest_Q_VO> getList = pretest_q_service.selectList(no);

		for(int i = getList.size(); i > 0; i--){
			int mainRan = (int)(Math.random() * getList.size());
	
			Map<String, Object> quiz = new HashMap<String, Object>();
			quiz.put("question", getList.get(mainRan).getQuestion());

			List<Pretest_Opt_VO> optList = pretest_opt_service.selectList(getList.get(mainRan).getPretest_q_no());
			List<Pretest_Opt_VO> optListRan = new ArrayList<Pretest_Opt_VO>();
			
			for(int j = optList.size(); j>0; j--){
				int subRan = (int)(Math.random() * optList.size());
				optListRan.add(optList.get(subRan));
				optList.remove(subRan);
			}

			quiz.put("opts", optListRan);
			pre_pretest.add(quiz);
			getList.remove(mainRan);

			if(pre_pretest.size() == 5)
				break;
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try{
			jsonString = mapper.writeValueAsString(pre_pretest);
		}catch (JsonProcessingException e){
			e.printStackTrace();
		}
		
		model.addAttribute("question", jsonString);
		return PRETEST + "question.jsp";
	} 
	
	@RequestMapping("/pretest/writeform")
	public String writeform(Model model) {
		return PRETEST + "write.jsp";
	}
	
	@RequestMapping("/pretest/write")
	public String write(Model model, Pretest_VO pvo, Pretest_Q_VO qvo, Pretest_Opt_VO ovo) {
		
		// .xml 에 저장하기 (service > dao > xml)
		int vop = pretest_service.insert(pvo);
		int voq = pretest_q_service.insert(qvo);
		int voo = pretest_opt_service.insert(ovo);
		
		// result.jps 로 데이터 보내기
		model.addAttribute("vop", vop);
		model.addAttribute("voq", voq);
		model.addAttribute("voo", voo);
		model.addAttribute("status", "write");
		model.addAttribute("url", "clink/pretest/list");
		
		return PRETEST + "result.jsp";
	}
	
	@RequestMapping("/pretest/test")
	public String test(Model model) {
		
		return PRETEST + "test.jsp";
	}
	
	@RequestMapping("/pretest/js_test")
	public String js_test(Model model) {
		
		return PRETEST + "js_test.jsp";
	}
	
	
	
}
