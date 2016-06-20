package kr.or.davizn.etcController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.dataService.UserStrgService;
import kr.or.davizn.etcService.JoinService;
import kr.or.davizn.memberDTO.DaviznMemberDTO;
import kr.or.davizn.memberService.DaviznMemberService;

@Controller
@RequestMapping("/join/")
public class JoinController {

	@Autowired
	JoinService service;
	
	@Autowired
	UserStrgService storageService;

	// 회원가입
	@RequestMapping("joinMember.dvn")
	public String joinMember(DaviznMemberDTO member) {
		String view = null;
		String userid = member.getUserid();
		int result = service.insertMember(member);
		
		if (result > 0) {
			view = "redirect:/auth/grantAuth.dvn?userid=" + userid;
		} else {
			view = "redirect:/signup.dvn";
		}
		return view;
	}

	// 회원가입 닉네임 중복 비동기 처리
	@RequestMapping("checkNickname.dvn")
	public @ResponseBody String checkNickname(@RequestParam String nickname) {
		String result = service.checkNickname(nickname);
		return result;
	}

	@RequestMapping("checkUserid.dvn")
	public @ResponseBody String checkMemberid(@RequestParam String userid) {
		String result = service.checkMemberid(userid);
		return result;
	}

	// 회원 가입 시 1개의 저장소 부여
	@RequestMapping("newStorage.dvn")
	public String newStorage(String strgname, String userid) {
		storageService.addStorage(strgname, userid);
		return "joinus.sign-up-ok";
	}

}
