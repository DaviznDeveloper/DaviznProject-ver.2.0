package kr.or.davizn.etcController;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("index.dvn")
	public String moveIndex(){
		
		return "home.index"; 
	}
}