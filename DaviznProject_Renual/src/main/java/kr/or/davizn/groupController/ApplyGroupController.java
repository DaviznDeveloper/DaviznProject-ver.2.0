package kr.or.davizn.groupController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.groupDTO.ApplyGroupDTO;
import kr.or.davizn.groupService.ApplyGroupService;

@Controller
@RequestMapping("/apply/")
public class ApplyGroupController {
   
   
   @Autowired
   ApplyGroupService applyService;
   
   //그룹에 가입신청하기
   @RequestMapping(value="applyGroup.dvn",produces="application/text; charset=utf8")
   @Transactional
   public @ResponseBody String applyGroup(Principal principal,@RequestParam int groupseq){
      System.out.println("comcom");
      ApplyGroupDTO applydto = new ApplyGroupDTO();
      applydto.setUserid(principal.getName());
      applydto.setGroupseq(groupseq);
      if(applyService.checkMember(applydto) != 0) return "이미 신청하셨습니다. 조금만 기다려주세요. 곧 처리해드리겠습니다.";
      applyService.addGroupMember(applydto);
      return "신청이 완료되었습니다.";
   }
}