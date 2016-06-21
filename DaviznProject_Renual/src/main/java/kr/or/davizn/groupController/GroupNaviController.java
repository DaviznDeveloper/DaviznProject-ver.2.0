package kr.or.davizn.groupController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.groupDTO.GroupInfoDTO;
import kr.or.davizn.groupService.GroupInfoService;

@Controller
@RequestMapping("/groupNavi/")
public class GroupNaviController {
	
	@Autowired
	GroupInfoService ginfoservice;
	
	//그룹 메인 페이지 이동
	@RequestMapping("goGroupMain.dvn")
	public String goGroupMain(Model model){
		
		List<GroupInfoDTO> randomList = ginfoservice.randomGroupList();
		model.addAttribute("rlist", randomList);
		
		return "group.group-main";
		
	}
	
	//그룹 검색 리스트 얻기
	@RequestMapping("searchGroupList.dvn")
	public @ResponseBody List<GroupInfoDTO> searchGroupList(String keyword){
		List<GroupInfoDTO> searchList = ginfoservice.searchGroupList(keyword);
		System.out.println("검색 리스트 : "+searchList);
		return searchList;
	}
	
	@RequestMapping("goGroupInfo.dvn")
	public String goGroupInfo(Principal principal){
		
		return "group.group-info";
	}
	
	

	
}
