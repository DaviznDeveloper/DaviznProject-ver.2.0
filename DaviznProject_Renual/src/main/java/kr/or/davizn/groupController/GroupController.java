package kr.or.davizn.groupController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.datainfoService.GroupDataService;
import kr.or.davizn.groupDTO.ApplyGroupDTO;
import kr.or.davizn.groupDTO.GroupInfoDTO;
import kr.or.davizn.groupDTO.GroupListDTO;
import kr.or.davizn.groupDTO.GroupMemberDTO;
import kr.or.davizn.groupService.ApplyGroupService;
import kr.or.davizn.groupService.GroupInfoService;
import kr.or.davizn.groupService.GroupMemberService;
import kr.or.davizn.memberDTO.AuthorityDTO;
import kr.or.davizn.memberService.AuthorityService;

@Controller
@RequestMapping("/group/")
public class GroupController {
   
   @Autowired
   GroupInfoService groupInfoService;
   @Autowired
   GroupDataService groupdataService;
   @Autowired
   AuthorityService authorityService;
   @Autowired
   ApplyGroupService applyService;
   @Autowired
   GroupMemberService gmService;
   
   
   @RequestMapping("goGroupMain.dvn")
   public String goGroupMain(Principal principal,Model model){
      
      //생성한 그룹 리스트
      List<GroupListDTO> groupList = groupInfoService.getGroupList(principal.getName());
      //랜덤으로 그룹 리스트 출력
      List<GroupInfoDTO> randomList = groupInfoService.randomGroupList();
   
      
      model.addAttribute("groupList",groupList);
      model.addAttribute("rlist", randomList);
      
      
      return "group.group-main";
   }
   
   @RequestMapping("addGroup.dvn")
   @Transactional
   public String addGroup(GroupInfoDTO groupInfoDTO,Principal principal){
      GroupMemberDTO groupMemberDTO = new GroupMemberDTO();
      AuthorityDTO authorityDTO = new AuthorityDTO();
   
      /* groupinfo 테이블에 그룹 정보 추가 */
      groupInfoDTO.setGroupmaster(principal.getName());
      groupInfoService.addGroupInfo(groupInfoDTO);
      
      /* 
       * 방금 groupinfo에 추가한 그룹의 고유번호(groupseq) 가져와서
       * groupmember 테이블에 userid, 그룹 고유번호 추가 
       */
      int groupseq = groupInfoService.getGroupseq();   
      groupMemberDTO.setUserid(principal.getName());
      groupMemberDTO.setGroupseq(groupseq);
      gmService.addGroupMember(groupMemberDTO);   

      
      /*
       * 생성하는 그룹 접근을 위한 권한 생성
       * groupauth 테이블, auth 테이블에 생성된다. 
       */
      
      groupInfoService.addAuths(groupseq);
      
      /*
       * 그룹을 생성하는 사람이므로 마스터 권한을 제공한다.
       * 해당하는 권한과 id를 authdesign 테이블에 추가한다.
       */
      String role_name = "ROLE_"+groupseq+"_M";
      authorityDTO.setUserid(principal.getName());
      authorityDTO.setRole_name(role_name);
      groupInfoService.addAuthDesign(authorityDTO);
      
      return "redirect:/group/goGroupMain.dvn";
   }
   
   @RequestMapping("goGroupInfo.dvn")
   public String goGroupInfo(Principal principal,int groupseq,Model model){
	   List<AuthorityDTO> authoList = authorityService.getMemberAuths(principal.getName());
	   List<ApplyGroupDTO> applylist = applyService.showApplylist(groupseq);
	   List<GroupMemberDTO> memberlist = gmService.getMemberlis(groupseq); 
	   
	   model.addAttribute("groupseq",groupseq);
	   model.addAttribute("userid",principal.getName());
	   model.addAttribute("authoList",authoList);
	   model.addAttribute("memberlist",memberlist);
	   model.addAttribute("applylist",applylist);
	   
	   for(AuthorityDTO dto:authoList){
		   if(dto.getRole_name().equals("ROLE_"+groupseq+"_M")){
			   return "group.group-info-master";
		   }
	   }
	   return "group.group-info";
   }
   
   //그룹 검색 리스트 얻기
   @RequestMapping("searchGroupList.dvn")
   public @ResponseBody List<GroupInfoDTO> searchGroupList(String keyword){
      List<GroupInfoDTO> searchList = groupInfoService.searchGroupList(keyword);
      return searchList;
   }
   
   
 
   
   
   
   
  
}