package kr.or.davizn.groupController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.datainfoService.GroupDataService;
import kr.or.davizn.groupDTO.ApplyGroupDTO;
import kr.or.davizn.groupDTO.GroupMemberDTO;
import kr.or.davizn.groupInterface.GroupInfoDAO;
import kr.or.davizn.groupService.ApplyGroupService;
import kr.or.davizn.groupService.GroupInfoService;
import kr.or.davizn.groupService.GroupMemberService;
import kr.or.davizn.memberDTO.AuthorityDTO;

@Controller
@RequestMapping("/groupMember/")
public class GroupMemberController {
   
   @Autowired
   GroupMemberService gmservice;
   @Autowired
   GroupInfoService groupInfoService;
   @Autowired
   ApplyGroupService applyService;
   @Autowired
   GroupDataService groupdataService;
   
   
    //가입 신청 승인하기
   @RequestMapping("recognizeGroupMember.dvn")
   @Transactional
   public String recognizeGroupMember(String[] userid,int groupseq){
   
      for(String userid2:userid){
         GroupMemberDTO groupMemberDTO = new GroupMemberDTO();
         AuthorityDTO authorityDTO = new AuthorityDTO();
         ApplyGroupDTO applydto = new ApplyGroupDTO();
         String role_name = "ROLE_"+groupseq+"_W";
      
         applydto.setGroupseq(groupseq);
         applydto.setUserid(userid2);
   
         groupMemberDTO.setUserid(userid2);
         groupMemberDTO.setGroupseq(groupseq);
         groupMemberDTO.setRole_name(role_name);
         gmservice.addGroupMember(groupMemberDTO);   
      
         authorityDTO.setUserid(userid2);
         authorityDTO.setRole_name(role_name);
         
         applyService.deleteApply(applydto);
         groupInfoService.addAuthDesign(authorityDTO);
      }
      return "redirect:/group/goGroupMain.dvn";
      }
   
   @RequestMapping("locking.dvn")
   public String locking(String userid, int dataseq){
      int groupseq = groupdataService.getOneGroupData(dataseq).getGroupseq();
      return "redirect:/note/detailNote.dvn?dataseq="+dataseq+"&function=m";
   }
   
}