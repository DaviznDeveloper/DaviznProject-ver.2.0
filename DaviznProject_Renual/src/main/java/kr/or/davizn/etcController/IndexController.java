package kr.or.davizn.etcController;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	@RequestMapping("index.dvn")
	public String moveIndex(Principal principal){
		if(principal ==null){return "home.index";}
		return "redirect:index2.dvn?userid=" + principal.getName(); 
	}
	
	@RequestMapping("index2.dvn")
	public String moveIndex2(@RequestParam String userid,Model model){
		System.out.println("index2.dvn 에 들어옴");
		
		System.out.println("userid : " + userid);
		return "home.index";
	}
	
}