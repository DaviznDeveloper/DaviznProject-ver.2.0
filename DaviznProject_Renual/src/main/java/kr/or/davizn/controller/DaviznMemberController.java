package kr.or.davizn.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.or.davizn.model.dto.DaviznMemberDTO;
import kr.or.davizn.service.DaviznMemberService;

@Controller
@RequestMapping("/member/")
public class DaviznMemberController {
	
	@Autowired
	DaviznMemberService service;
	
	//회원가입
	@RequestMapping("joinMember.dvn")
	public String joinMember(DaviznMemberDTO member){
		
		String view = null;
		int result = service.insertMember(member);
		String userid = member.getUserid();
		if(result > 0){
			view = "redirect:grantAuth.dvn?userid="+userid;
		}else{
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
	public String moveProfile(){
		
		return "member.profile";
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
	
	@RequestMapping("profileModiAction.dvn")
	public String ProfileModiAction(DaviznMemberDTO member, HttpServletRequest request){
		System.out.println("회원 정보 수정(회원 정보 수정) 컨트롤러");
		String view = null;
		System.out.println("1111");
		CommonsMultipartFile file = member.getUploadImage();
		if(file != null && file.getSize() > 0 ){
			String filename = file.getOriginalFilename();
			String path = request.getRealPath("/resources/upload");
		}
		
		System.out.println("222");
		String filename = file.getOriginalFilename();
		System.out.println("33");
		String path = request.getRealPath("/resources/upload");
		System.out.println("44");
		String fullpath = path + "\\" + filename;
		System.out.println("55");
		System.out.println(filename + " / " + path + " / " + fullpath);
		
		
		return null;
	}
	
	
	
	
}