package kr.or.davizn.groupController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/group/")
public class GroupController {
	
	@RequestMapping("addGroup.dvn")
	public @ResponseBody List addGroup(){
		List list = new ArrayList();
		return list;
	}
}
