package kr.or.davizn.groupController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.groupDTO.GroupInfoDTO;

@Controller
@RequestMapping("/group/")
public class GroupController {
	
	@RequestMapping("addGroup.dvn")
	public String addGroup(GroupInfoDTO groupInfoDTO){
		
		//insert userid, auth ... into authodesign (table)
		//insert userid, groupseq,auth ... into groupmember (table)
		//insert userid(master), groupname, g_introduce ... into groupinfo(table)
		
		return "redirect:/group/showGroupList.dvn";
	}
	
	@RequestMapping("showGroupList.dvn")
	public String showGroupList(){
		return "group.group-main";
	}
}
