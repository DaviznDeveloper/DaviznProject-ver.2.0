package kr.or.davizn.groupController;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.groupDTO.GroupDataDTO;

@Controller
@RequestMapping("/groupdata/")
public class GroupDataController {

	
	@RequestMapping("addGroupData.dvn")
	public String addGroupData(GroupDataDTO groupdatadto, Principal principal){
		groupdatadto.setUserid(principal.getName());
		return "redirect:/group/goGroupList.dvn";
	}
}
