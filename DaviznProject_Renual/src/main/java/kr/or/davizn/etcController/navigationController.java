package kr.or.davizn.etcController;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//
	@RequestMapping("groupNavi.dvn")
	public String moveGroup(){
		return "group.group-main";
	}
	
	//커뮤니티 게시판 이동
    @RequestMapping("communityNavigation.dvn")
    public String moveCommunity(){
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
