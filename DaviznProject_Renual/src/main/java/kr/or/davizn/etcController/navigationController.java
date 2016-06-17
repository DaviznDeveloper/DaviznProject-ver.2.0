package kr.or.davizn.etcController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.memberDTO.DaviznMemberDTO;
import kr.or.davizn.memberService.DaviznMemberService;

@Controller
public class navigationController {
	
	// 회원가입 창 이동
	@RequestMapping("signup.dvn")
	public String moveSignUp() {

		return "joinus.signup";
	}
	
	
	// 로그인 창 이동
	@RequestMapping("signin.dvn")
	public String moveSignIn() {

		return "joinus.sign-in";
	}

	// 데이터 관리 창 이동
	@RequestMapping("userStrg.dvn")
	public String moveDataMain(Principal principal) {

		if (principal == null) {
			return "datamanage.data-repo";
		}
		String userid = principal.getName();
		return "redirect:/userStrg/showStorageList.dvn?userid="+userid;

	}

	//커뮤니티 게시판 이동
    @RequestMapping("communityNavigation.dvn")
    public String moveCommunity(){
    	System.out.println("커뮤니티 네이 등장");
       return "redirect:/communityList.dvn";
    }
    
  //1:1 게시판 창 이동
    @RequestMapping("QnANavigation.dvn")
    public String moveQnA(){
       
       return "redirect:/QnAList.dvn";
    }
    
	// 사이트 관리 창 이동
	@RequestMapping("admin.dvn")
	public String moveAdmin() {

		return "admin.site-manage";
	}

}
