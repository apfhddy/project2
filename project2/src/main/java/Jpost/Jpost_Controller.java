package Jpost;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import Apply.Apply_Service;
import Empl_Type_C.Empl_Type_C_Service;
import Empl_Type_C.Empl_Type_C_VO;
import Jarea_C.Jarea_C_Service;
import Jarea_C.Jarea_C_VO;
import Jpost_Detail.Jpost_Detail_Service;
import Jpost_Detail.Jpost_Detail_VO;
import Lv_C.Lv_C_Service;
import Lv_C.Lv_C_VO;
import Posi_C.Posi_C_Service;
import Posi_C.Posi_C_VO;
import School_C.School_C_Service;
import School_C.School_C_VO;
import Worktime_C.Worktime_C_Service;
import Worktime_C.Worktime_C_VO;
import path.Encry;
import path.ProjectPath;

@Controller
public class Jpost_Controller implements ProjectPath{

	private Jpost_Service jpost_service;
	private Jpost_Detail_Service jpost_detail_service;
	private Empl_Type_C_Service empl_type_c_service;
	private Jarea_C_Service jarea_c_service;
	private Worktime_C_Service worktime_c_service;
	private Lv_C_Service lv_c_service;
	private School_C_Service school_c_service;
	private Posi_C_Service posi_c_service;
	private Apply_Service apply_service;
	
	public Jpost_Controller(Jpost_Service jpost_service, Jpost_Detail_Service jpost_detail_service, Empl_Type_C_Service empl_type_c_service, Worktime_C_Service worktime_c_service, Jarea_C_Service jarea_c_service, Lv_C_Service lv_c_service, School_C_Service school_c_service, Posi_C_Service posi_c_service, Apply_Service apply_service) {
		this.jpost_service = jpost_service;
		this.jpost_detail_service = jpost_detail_service;
		this.empl_type_c_service = empl_type_c_service;
		this.worktime_c_service = worktime_c_service;
		this.jarea_c_service = jarea_c_service;
		this.lv_c_service = lv_c_service;
		this.school_c_service = school_c_service;
		this.posi_c_service = posi_c_service;
		this.apply_service = apply_service;
	}
	
	// 페이징 처리는 안함 > 무한 스크롤로 대체
	@RequestMapping("/jpost/list")
	public String list(Model model, String type,String word) {
		
		// 채용공고 데이터 불러오기
		List<Map<String, Object>> all_list = jpost_service.all_list();
		
		// 검색 기능										
		// - 작동 안됨!!!!!!!!!!!!!!!!!
		HashMap<String, Object> mapSearch = new HashMap<String, Object>();
		
		if(type != null && type.equals("")) {
			type = null;
			word = null;
		}
		
		mapSearch.put("type", type);
		mapSearch.put("word", word);

		List<Jpost_VO> list = jpost_service.selectList(mapSearch);
		
		model.addAttribute("all_list", all_list);	
		model.addAttribute("list", list);	

		//	all_list 메소드로 대체 됨
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<Jpost_VO> list = jpost_service.selectList(map);
//		model.addAttribute("list", list);						// "list"는 model을 통해 날릴 변수이고, list는 jpost_service.selectList(map)을 담은 변수의 key값
		
		return JPOST + "list.jsp";
		
	}
	
	
	@RequestMapping("/jpost/writeform")
	public String writeform(Model model) {
		
		// 공통 테이블 데이터 불러오기 - 근무형태
		List<Empl_Type_C_VO> elist = empl_type_c_service.selectList();	
		
		// 공통 테이블 데이터 불러오기 - 근무시간
		List<Worktime_C_VO> wlist = worktime_c_service.selectList();	
		
		// 공통 테이블 데이터 불러오기 - 직군
		List<Jarea_C_VO> jlist = jarea_c_service.selectList();	
		
		// 공통 테이블 데이터 불러오기 - 경력
		List<Lv_C_VO> llist = lv_c_service.selectList();
		
		// 공통 테이블 데이터 불러오기 - 교육
		List<School_C_VO> slist = school_c_service.selectList();	
		
		// 공통 테이블 데이터 불러오기 - 직급
		List<Posi_C_VO> plist = posi_c_service.selectList();	
		
		model.addAttribute("elist", elist);
		model.addAttribute("wlist", wlist);
		model.addAttribute("jlist", jlist);
		model.addAttribute("llist", llist);
		model.addAttribute("slist", slist);
		model.addAttribute("plist", plist);
		
		return JPOST + "write.jsp";
	}
	
	@Autowired
	private ServletContext application;	// 파일업로드에 필요(application)
	
	@RequestMapping("/jpost/write")
	//HttpServletRequest 사용
	public String write(HttpServletRequest request, Jpost_VO vo) {			// model 쓰는 이유 : addAttribute 쓰려고
																// vo를 파라미터 값을 받아 올 수 없어서 request를 사용 
																// >> 특징 : 일회성 데이터들이기 때문에 저장할 수 있도록 String howto = request.getParameter를 쓰고 new 생성자로 해당 데이터들을 받아와서 저장해야함
																// >> 장점 : 분산돼 있는 여러 vo들을 한번에 사용할 수 있음

//		request.getParameter("title");							// 받아오는 데이터를 일회성으로 저장하지 않고 request의 getParameter로 보내는 용도
																// - 데이터들을 DB에 저장하기 위해선 하기 내용 처럼 데이터 받아와야함
		
		// Jpost 테이블 칼럼
		String jpost_id = Encry.getUUID("JJPXX");	
		String howto = request.getParameter("howto");			// 반환 타입에 맞는 형태로 값을 받아줘야함 / getParameter가 String 타입이라서 맨 앞에 String으로 타입을 맞춰준다
		String title = request.getParameter("title");			// - 사용자에게 입력 받을 값들만 파라미터로 기입
		String detail = request.getParameter("detail");			// Service에서 CLOB을 String 으로 형변환
		String start_date = request.getParameter("start_date");		
		String end_date = request.getParameter("end_date");		
		String locate = request.getParameter("locate");		
		String url = request.getParameter("url");		
		String file_name = request.getParameter("file_name");
		
		// empl_type 테이블 칼럼
		String empl_type_cno = request.getParameter("empl_type_cno");

		// jarea 테이블 칼럼
		String jarea_cno = request.getParameter("jarea_cno");

		// worktime 테이블 칼럼
		String worktime_cno = request.getParameter("worktime_cno");
		
		// school 테이블 칼럼
		String school_cno = request.getParameter("school_cno");
		
		// lv 테이블 칼럼
		String lv_cno = request.getParameter("lv_cno");
		
		// posi 테이블 칼럼
		String posi_cno = request.getParameter("posi_cno");
		
		
		
		// Jpost_detail 테이블 칼럼
		String jpost_detail_id = Encry.getUUID("JJPDX");
		String task = request.getParameter("task");
		String salary = request.getParameter("salary");
		String type = request.getParameter("type");
		
		
		// String을 Date 타입으로 형변환
		Date sstart_date  = Jpost_Service.getSQLDate(start_date);	// String을 Date 타입으로 형 변환하는 메소드
		Date send_date  = Jpost_Service.getSQLDate(end_date);
		
		// 파일 업로드
		String savePath = application.getRealPath("/resources/upload");
		String filename = null;
		
		// Jpost_VO 관련		>>> request로 넘기려면 어떻게??
		MultipartFile fileupload = vo.getJpost_upload();
		
		if(fileupload != null && !fileupload.isEmpty()) {
			filename = fileupload.getOriginalFilename();
			
			File saveFile = new File(savePath, filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")), time, filename.substring(filename.lastIndexOf(".")));
			
				saveFile = new File(savePath, filename);
			}
			
			try {
				fileupload.transferTo(saveFile);
			}catch(IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			vo.setFile_name(filename);
		
		}else {
			vo.setFile_name("no_file");
		}
		String bmember_id = Encry.getBmember_id(request.getSession());
		System.out.println(salary);
		// 두 개의 다른 테이블을 Join해서 쓰기 때문에 각각 생성자 생성
		Jpost_VO jvo = new Jpost_VO(jpost_id,bmember_id, Integer.parseInt(howto), title, detail, sstart_date, send_date, locate, url, file_name);
		Jpost_Detail_VO dvo = new Jpost_Detail_VO(jpost_detail_id, Integer.parseInt(jarea_cno),Integer.parseInt(worktime_cno),Integer.parseInt(empl_type_cno), Integer.parseInt(posi_cno), task, Integer.parseInt(lv_cno), salary, Integer.parseInt(school_cno), Integer.parseInt(type));
		dvo.setJpost_id(jpost_id);								// int를 String 타입으로 형변환하는 방법 : 파라미터 값에 Integer.parseInt(howto)로 입력
																	// 사용자에게 입력 받을 값들만 파라미터로 기입

		// jpost.xml / jpost_detail.xml 의 insert에 각각의 데이터 저장
		jpost_service.insert(jvo);									// 기입된 데이터가 담긴 DB 테이블의 칼럼을 su에 담기 / 위에 생성한 new 생성자를 파라미터에 담음
		jpost_detail_service.insert(dvo);							// 외래키로 참조할 테이블의 jpost_dvo 데이터를 받아오는 메소드 / 위에 생성한 new 생성자를 파라미터에 담음
		
		request.setAttribute("status","write");						// status에 "write"를 보내기
		request.setAttribute("url","/jpost/list");			// url을 /clink/jpost/list로 보내기
		
		return JPOST + "result.jsp";
		
	}
	
	
	@RequestMapping("/jpost/content")
	public String content(Model model, String no) {		

		System.out.println("jpost/content 에서 no = " + no);
		
		// apply 테이블 데이터 >> jpost_content 에서 사용
		List<Map<String, Object>> apply_vo = apply_service.apply_vo();
		Map<String,Object> map = jpost_service.getContent(no);
		List<Jpost_VO> jpost_vo = jpost_service.jpost_vo(no);
		
		model.addAttribute("vo", map);								// "vo" 는 @RequestMapping("/jpost/write") 에서 생성한 vo 객체
		model.addAttribute("jvo", jpost_vo);						
		model.addAttribute("apply_vo", apply_vo);		// 얘 보내는 목적이 뭐임???

		return JPOST + "content.jsp";
	}
	
	@RequestMapping("/jpost/updateform")							// DB에 저장된 데이터를 불러와서 update.jsp로 해당 데이터를 보내는 역할
	public String updateform(HttpServletRequest request, String no) {
		
		// 기존에 작성했던 데이터 가져오기
		Map<String, Object> map = jpost_service.getContent(no);		// DB에 저장했던 채용공고 불러오기
		List<Map<String, Object>> all_list = jpost_service.all_list();		// 채용공고에 들어가는 모든 데이터들 불러오기 (jpost, jpost_detail, empl_type_c)

		request.setAttribute("vo", map);							// jpost의 데이터(map)들을 "vo"라는 임의의 변수에 담아서 보내기
		request.setAttribute("all_list", all_list);					// 채용공고에 들어가는 모든 데이터들 all_list에 담아서 보내기
		
		// 공통 테이블 데이터 불러오기
		List<Empl_Type_C_VO> elist = empl_type_c_service.selectList();	// empl_type의 고용형태 불러오기
		List<Jarea_C_VO> jlist = jarea_c_service.selectList();	
		List<Worktime_C_VO> wlist = worktime_c_service.selectList();	
		List<School_C_VO> slist = school_c_service.selectList();	
		List<Posi_C_VO> plist = posi_c_service.selectList();	
		List<Lv_C_VO> llist = lv_c_service.selectList();	
		
		request.setAttribute("elist", elist);						// empl_type의 고용형태(elist)를 "elist"에 담아서 보내기
		request.setAttribute("jlist", jlist);
		request.setAttribute("wlist", wlist);
		request.setAttribute("slist", slist);
		request.setAttribute("llist", llist);
		request.setAttribute("plist", plist);
			
		return JPOST + "update.jsp";
	}

	@RequestMapping("/jpost/update")										
	public String update(HttpServletRequest request, String no) {		// model과 request는 같이 쓸 필요없음
		
		// update.jsp 에서 수정한 데이터를 가져오기
		// Map<String, Object> map = jpost_service.getContent(no);		// DB에 저장된 데이터를 불러오는거임... 수정된거 가져오는거 아님

		// Jpost 테이블 칼럼
		String jpost_id = Encry.getUUID("JJPXX");				// update.jps 에서 input type="hidden"
		String howto = request.getParameter("howto");			
		String title = request.getParameter("title");			
		String detail = request.getParameter("detail");			
		String start_date = request.getParameter("start_date");	
		String end_date = request.getParameter("end_date");		
		String locate = request.getParameter("locate");		
		String url = request.getParameter("url");		
		String file_name = request.getParameter("file_name");
		
		// Jpost_detail 테이블 칼럼
		String jpost_detail_id = Encry.getUUID("JJPDX");
		String task = request.getParameter("task");
		String salary = request.getParameter("salary");
		String type = request.getParameter("type");
		
		// jarea 테이블 칼럼
		String jarea_cno = request.getParameter("jarea_cno");
		
		// worktime 테이블 칼럼
		String worktime_cno = request.getParameter("worktime_cno");
		
		// empl_type 테이블 칼럼
		String empl_type_cno = request.getParameter("empl_type_cno");	
		
		// lv_c 테이블 칼럼
		String lv_cno = request.getParameter("lv_cno");
		
		// school_c 테이블 칼럼
		String school_cno = request.getParameter("school_cno");
		
		// posi_c 테이블 칼럼
		String posi_cno = request.getParameter("posi_cno");
		
		// String을 Date 타입으로 형변환
		Date sstart_date  = Jpost_Service.getSQLDate(start_date);
		Date send_date  = Jpost_Service.getSQLDate(end_date);
		
		String bmember_id = Encry.getBmember_id(request.getSession());
		
		// Join할 테이블의 생성자 (수정된 데이터가 들어갈 칼럼 기입)
		// - int는 Integer로 형변환
		Jpost_VO vo = new Jpost_VO(jpost_id, bmember_id,Integer.parseInt(howto), title, detail, sstart_date, send_date, locate, url, file_name);
		Jpost_Detail_VO dvo = new Jpost_Detail_VO(jpost_detail_id, Integer.parseInt(jarea_cno), Integer.parseInt(worktime_cno), Integer.parseInt(empl_type_cno), Integer.parseInt(posi_cno), task, Integer.parseInt(lv_cno), salary, Integer.parseInt(school_cno), Integer.parseInt(type));

		
		// DB에 수정된 내용 저장
		jpost_service.update(vo);
		jpost_detail_service.update(dvo);
		
		request.setAttribute("status", "update");
		request.setAttribute("url", "/jpost/content?no=" + vo.getJpost_id());

		return JPOST + "result.jsp";
	}
	
	@RequestMapping("/jpost/hidden")
	public String hidden(HttpServletRequest request, String no) {
		
		jpost_service.hidden(no);						// 삭제버튼 클릭시 숨김처리
		
		// 삭제 후 list 로 넘어갈때, no 가 같이 넘어가서 다른 채용 공고들이 바로 안 보임
		System.out.println("/jpost/hidden 에서 no = "+no);
		
		request.setAttribute("status", "hidden");
		request.setAttribute("url", "/jpost/list");
		
		return JPOST + "list.jsp";
	}
	
	
}
