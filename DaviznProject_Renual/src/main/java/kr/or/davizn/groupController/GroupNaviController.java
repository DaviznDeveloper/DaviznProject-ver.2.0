package kr.or.davizn.groupController;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groupNavi/")
public class GroupNaviController {
	
	@RequestMapping("goGroupInfo.dvn")
	public String goGroupInfo(Principal principal){
		
		return "group.group-info";
	}

	
}
