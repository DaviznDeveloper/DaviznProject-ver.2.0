package kr.or.davizn.groupController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group/")
public class groupController {
	
	@RequestMapping("groupInfo.dvn")
	public String goGroupInfo(){
		return "group.group-info";
	}
	
	@RequestMapping("groupInfoMaster.dvn")
	public String goGroupInfoMaster(){
		return "group.group-info-master";
	}

}
