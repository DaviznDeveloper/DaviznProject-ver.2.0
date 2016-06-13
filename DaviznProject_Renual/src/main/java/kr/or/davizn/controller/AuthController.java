package kr.or.davizn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.service.AuthorityService;

@Controller
public class AuthController {
	
	@Autowired
	private AuthorityService service;
	
	
	//권한 부여
	@RequestMapping("/member/grantAuth.dvn")
	public String grantAuth(@RequestParam String userid){
		String view = null;
		int result = service.grantAuth(userid);
		if(result > 0){
			view = "joinus.sign-up-ok";
		}else{
			view = "joinus.signup";
		}
		return view;
	}
}
