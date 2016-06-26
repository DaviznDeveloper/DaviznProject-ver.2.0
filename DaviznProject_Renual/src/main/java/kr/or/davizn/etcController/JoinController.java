package kr.or.davizn.etcController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.datainfoService.UserStrgService;
import kr.or.davizn.etcService.JoinService;
import kr.or.davizn.memberDTO.DaviznMemberDTO;

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
			System.out.println("회원가입성공//권한부여하러 감");
			view = "redirect:/auth/grantAuth.dvn?userid=" + userid;
		} else {
			view = "redirect:/signup.dvn";
		}
		return view;
	}

	// 회원가입 이메일 중복 비동기 처리
	@RequestMapping(value="checkAccount.dvn" ,produces="application/text; charset=utf8")
	public @ResponseBody String checkAccount(@RequestParam String account) {
		String result = service.checkAccount(account);
		return result;
	}

	//회원가입 회원 아이디 중복 비동기 처리
	@RequestMapping(value="checkUserid.dvn",produces="application/text; charset=utf8")
	public @ResponseBody String checkUserid(@RequestParam String userid) {
		String result = service.checkUserid(userid);
		return result;
	}

	// 회원 가입 시 1개의 저장소 부여
	@RequestMapping(value="newStorage.dvn")
	public String newStorage(String userid) {
		String strgname="저장소이름";
		System.out.println("Hi, 저장소 줄게");
		
		storageService.addStorage(strgname, userid);
		return "joinus.sign-up-ok";
	}

}
