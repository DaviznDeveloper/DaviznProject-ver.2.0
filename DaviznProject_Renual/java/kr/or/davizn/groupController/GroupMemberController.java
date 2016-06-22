package kr.or.davizn.groupController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.groupService.GroupMemberService;

@Controller
@RequestMapping("/groupMember/")
public class GroupMemberController {
	
	@Autowired
	GroupMemberService gmservice;
	
	
	
}
