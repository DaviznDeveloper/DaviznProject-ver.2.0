package kr.or.davizn.memberController;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	
	//프로필 창 이동
	@RequestMapping("profile.dvn")
	@Transactional
	public String moveProfile(Principal principal, Model model){
		String view = null;
		String userid = principal.getName();
		DaviznMemberDTO member = service.selectOneMember(userid);
		
		if(member != null){
			model.addAttribute("member", member);
			view = "member.profile";
		}else{
			view = "home.index";
		}
		
		return view;
		
	}
	
	//회원 정보 수정 창 이동(기존 정보 확인)
	@RequestMapping("profileModi.dvn")
	public String moveProfileModi(Principal principal, Model model){
		String view = null;
		String userid = principal.getName();
		DaviznMemberDTO member = service.selectOneMember(userid);
		if(member != null){
			model.addAttribute("member", member);
			view = "member.profile-modi";
		}else{
			view = "home.index";
		}
		return view;
	}
	
	//회원 정보 수정 창 이동(회원 정보 업데이트)
	@RequestMapping("profileModiAction.dvn")
	public String ProfileModiAction(DaviznMemberDTO member, HttpServletRequest request,Principal principal) 
			throws IOException{
		System.out.println("회원 수정 컨트롤러");
		String view = null;
		int result = service.updateMember(member, request, principal);
		if(result > 0){
			view = "redirect:profile.dvn";
		}else{
			view = "home.index";
		}
		return view;
	
	}
	
/*//	//그룹장이 회원 초대
//	@RequestMapping("inviteMember.dvn")
//	public @ResponseBody List<DaviznMemberDTO> inviteMember(){
//		
//	}
*/	
	
	
	
	
}