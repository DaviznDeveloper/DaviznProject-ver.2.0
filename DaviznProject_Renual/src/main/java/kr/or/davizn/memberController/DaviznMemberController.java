package kr.or.davizn.memberController;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.or.davizn.memberDTO.DaviznMemberDTO;
import kr.or.davizn.memberService.DaviznMemberService;

@Controller
@RequestMapping("/member/")
public class DaviznMemberController {
	
	@Autowired
	DaviznMemberService service;
	
	//회원가입
	@RequestMapping("joinMember.dvn")
	public String joinMember(DaviznMemberDTO member){
		System.out.println("회원가입 컨트롤러");
		String view = null;
		int result = service.insertMember(member);
		String userid = member.getUserid();
		if(result > 0){
			System.out.println("회원가입 성공/권한부여하러감");
			view = "redirect:/auth/grantAuth.dvn?userid="+userid;
		}else{
			System.out.println("회원가입실패");
			view = "joinus.signup";
		}
		return view;
	}

	//회원가입 닉네임 중복 비동기 처리
	@RequestMapping("/checkNickname.dvn")
	public @ResponseBody String checkNickname(@RequestParam String nickname){
		System.out.println("닉네임 중복처리 컨트롤러");
		System.out.println(nickname);
		String result = service.checkNickname(nickname);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/checkUserid.dvn")
	public @ResponseBody String checkMemberid(@RequestParam String userid){
		System.out.println("userid 중복처리 컨트롤러");
		System.out.println(userid);
		String result = service.checkMemberid(userid);
		System.out.println(result);
		return result;
	}
	
	//프로필 창 이동
	@RequestMapping("profile.dvn")
	public String moveProfile(Principal principal, Model model){
		System.out.println("프로필 창 이동(기존 정보 확인)");
		String view = null;
		String userid = principal.getName();
		DaviznMemberDTO member = service.selectOneMember(userid);
		
		if(member != null){
			model.addAttribute("member", member);
			view = "member.profile";
			System.out.println("프로필 검색 성공");
		}else{
			view = "home.index";
			System.out.println("프로필 검색 실패");
		}
		
		return view;
		
	}
	
	//회원 정보 수정 창 이동(기존 정보 확인)
	@RequestMapping("profileModi.dvn")
	public String moveProfileModi(Principal principal, Model model){
		System.out.println("회원정보 수정(기존 정보 확인) 컨트롤러");
		String view = null;
		String userid = principal.getName();
		
		DaviznMemberDTO member = service.selectOneMember(userid);
		
		if(member != null){
			model.addAttribute("member", member);
			view = "member.profile-modi";
			System.out.println("회원 정보 검색 성공");
		}else{
			view = "home.index";
			System.out.println("회원정보 검색 실패");
		}
		
		return view;
	}
	
	//회원 정보 수정 창 이동(회원 정보 업데이트)
	@RequestMapping("profileModiAction.dvn")
	public String ProfileModiAction(DaviznMemberDTO member, HttpServletRequest request,Principal principal) 
			throws IOException{
		System.out.println("회원 정보 수정(회원 정보 수정) 컨트롤러");
		String view = null;
		int result = service.updateMember(member, request, principal);
		if(result > 0){
			System.out.println("회원 정보 업로드 완료");
			view = "redirect:profile.dvn";
		}else{
			System.out.println("회원 정보 업로드 실패");
			view = "home.index";
		}
		
		return view;
	
	}
	
	
	
	
	
}