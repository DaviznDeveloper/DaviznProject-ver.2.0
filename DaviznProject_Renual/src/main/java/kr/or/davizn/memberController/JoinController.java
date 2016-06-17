package kr.or.davizn.memberController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.memberDTO.DaviznMemberDTO;
import kr.or.davizn.memberService.DaviznMemberService;

@Controller
@RequestMapping("/join/")
public class JoinController {

	@Autowired
	DaviznMemberService service;

	// 회원가입
	@RequestMapping("joinMember.dvn")
	public String joinMember(DaviznMemberDTO member) {
		System.out.println("회원가입 컨트롤러");
		String view = null;
		int result = service.insertMember(member);
		String userid = member.getUserid();
		if (result > 0) {
			System.out.println("회원가입 성공/권한부여하러감");
			view = "redirect:/auth/grantAuth.dvn?userid=" + userid;
		} else {
			System.out.println("회원가입실패");
			view = "redirect:/signup.dvn";
		}
		return view;
	}
	
	//회원가입 닉네임 중복 비동기 처리
		@RequestMapping("checkNickname.dvn")
		public @ResponseBody String checkNickname(@RequestParam String nickname){
			System.out.println("닉네임 중복처리 컨트롤러");
			System.out.println(nickname);
			String result = service.checkNickname(nickname);
			System.out.println(result);
			return result;
		}
		
		@RequestMapping("checkUserid.dvn")
		public @ResponseBody String checkMemberid(@RequestParam String userid){
			System.out.println("userid 중복처리 컨트롤러");
			System.out.println(userid);
			String result = service.checkMemberid(userid);
			System.out.println(result);
			return result;
		}
}
