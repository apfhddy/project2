package ExTest_Pract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ExTest_Opt.ExTest_Opt_DTO;
import ExTest_Opt.ExTest_Opt_Service;
import path.ProjectPath;

@Controller
public class ExTest_Pract_Controller implements ProjectPath{
	private ExTest_Pract_Service extest_prack_service;
	private ExTest_Opt_Service extest_opt_service;
	
	public ExTest_Pract_Controller(ExTest_Pract_Service extest_prack_service,ExTest_Opt_Service extest_opt_service) {
		this.extest_prack_service = extest_prack_service;
		this.extest_opt_service = extest_opt_service;
	}
	
	@RequestMapping("getExTest_Prack")
	public String getExTest_Prack(int key,Model m) {
		List<Map<String,Object>> mainPract = new ArrayList<>();
		List<ExTest_Pract_DTO> getList = extest_prack_service.getList(key); // 채용글에 관련된 질문 리스트로
		for(int i = getList.size(); i > 0; i--) {
    		int mainRan = (int)(Math.random()*getList.size()); //리스트 사이즈 랜덤돌려 랜덤 숫자 뽑기
    		Map<String,Object> onePract = new HashMap<String, Object>();//하나의 질문과 선택을 묶기 위한 map
    		onePract.put("question", getList.get(mainRan).getQuestion()); // 일단 질문을 먼저 담고
    		
    		List<ExTest_Opt_DTO> optList = extest_opt_service.getList(getList.get(mainRan).getExtest_pract_no());//그 질문에 해당하는 선택지 리스트로
    		List<ExTest_Opt_DTO> optListRan = new ArrayList<ExTest_Opt_DTO>(); //리스트를 옳겨 담을 List생성
    		for(int j = optList.size(); j > 0; j--) {
    			int subRan = (int)(Math.random()*optList.size()); //리스트도 랜덤 돌려
    			optListRan.add(optList.get(subRan)); //랜덤문제를 옮겨 담음
    			optList.remove(subRan);//지우기 똑같은걸 받지 않게
    		}
    		onePract.put("opts", optListRan);
    		mainPract.add(onePract);
    		getList.remove(mainRan);
    		if(mainPract.size() == 15)break;
    	}
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(mainPract);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		m.addAttribute("question",jsonString);
		return TECH_TEST+"question.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}







