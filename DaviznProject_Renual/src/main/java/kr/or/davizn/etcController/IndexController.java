package kr.or.davizn.etcController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("index.dvn")
	public String moveIndex(){
		
		return "home.index"; 
	}
}