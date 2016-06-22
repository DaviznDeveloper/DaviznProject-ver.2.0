package kr.or.davizn.groupController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sharedata/")
public class ShareDataController {
	
	@RequestMapping("modifyNote")
	public String modifyNote(){
		return "";
	}
	
	@RequestMapping("deletleNote")
	public String deleteNote(){
		return "";
	}
}
