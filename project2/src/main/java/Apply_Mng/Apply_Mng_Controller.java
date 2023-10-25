package Apply_Mng;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import path.ProjectPath;

@Controller
public class Apply_Mng_Controller implements ProjectPath{

	private Apply_Mng_Service apply_mng_service;
	
	public Apply_Mng_Controller(Apply_Mng_Service apply_mng_service) {
		this.apply_mng_service = apply_mng_service;
	}
	
	@RequestMapping("/apply_mng/list")
	public String list(Model model) {
		
		List<Map<String, Object>> apply_all = apply_mng_service.apply_all();

		model.addAttribute("apply_all", apply_all);
		
		return APPLYMNG + "list.jsp";
	}
	
	
}
