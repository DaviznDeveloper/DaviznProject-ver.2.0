package kr.or.davizn.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class navigationController {
	
		//회원가입 창 이동
		@RequestMapping("signup.dvn")
		public String moveSignUp(){
			
			return "joinus.signup"; 
		}
		
		//로그인 창 이동
		@RequestMapping("signin.dvn")
		public String moveSignIn(){
			
			return "joinus.sign-in"; 
		}
		
		//회원 정보 창 이동
		/*@RequestMapping("profile.dvn")
		public String moveProfile(){
			
			return "member.profile";
		}
		
		//회원 정보 수정 창 이동
		@RequestMapping("profileModi.dvn")
		public String moveProfileModi(){
			
			return "member.profile-modi";
		}*/
		
		//데이터 관리 창 이동
		@RequestMapping("datamanage.dvn")
		public String moveDataMain(Principal principal){
			if(principal == null){return "datamanage.data-repo";}
	         return "redirect:/datamanage/showStorageList.dvn";
		}
		
		//대시보드 창 이동
		@RequestMapping("dashboard.dvn")
		public String moveDashboard(){
			
			return "dashboard.dashboard";
		}
		
		//사이트 관리 창 이동
		@RequestMapping("admin.dvn")
		public String moveAdmin(){
			
			return "admin.site-manage";
		}
		
}
