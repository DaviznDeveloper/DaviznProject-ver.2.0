package kr.or.davizn.dataInfoController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datainfoDTO.UserStrgDTO;
import kr.or.davizn.datainfoService.PersonalService;
import kr.or.davizn.datainfoService.UserStrgService;
import kr.or.davizn.groupDTO.GroupListDTO;
import kr.or.davizn.groupService.GroupInfoService;

@Controller
@RequestMapping("/personalData/")
public class PersonalDataController {

   @Autowired
   private PersonalService personalDataService;
   @Autowired
   private GroupInfoService groupInfoService;
   @Autowired
   private UserStrgService storageService;
   

   
   //데이터 리스트 보기
   @RequestMapping("showPersonalDataList.dvn")
   public String showPersonalDataList(Model model, int strgseq,Principal principal){
      List<PersonalDataDTO> pdatalist = personalDataService.showPersonalDataList(strgseq);
      List<GroupListDTO> grouplist = groupInfoService.getGroupList(principal.getName());
      List<UserStrgDTO> storagelist = storageService.showStorageList(principal.getName());
      model.addAttribute("storagelist", storagelist);
      model.addAttribute("pdatalist", pdatalist);
      model.addAttribute("groupList",grouplist);
      model.addAttribute("strgseq",strgseq);
      model.addAttribute("listsize",pdatalist.size());
      return "datamanage.data-list";
   }
   
  	
 	/*
 	 * /datamanage/data-list.jsp 에서 제목 클릭하여 상세보기
 	 */
 	@RequestMapping("detailPersonalData.dvn")
 	public String detailPersonalData(@RequestParam int datatype,
 									 @RequestParam int strgseq,
 									 @RequestParam int dataseq){
 		String view = null;
 		if(datatype==1){
 			//노트 데이터 상세 보기
 			view ="redirect:/note/detailNote.dvn?dataseq="+dataseq+"&function=d";
 		}else if(datatype==2){
 			//스케치 상세 보기
 			view ="redirect:/sketch/detailsketch.dvn?dataseq="+dataseq+"&function=d";
 		}else if(datatype==3){
 			//목표 상세 보기
 			view = "redirect:/goal/detailGoal.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
 		}else if(datatype==4){
 			//일정 상세보기
 			view = "redirect:/schedule/detailSchedule.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
 		}else{
 			
 		}
 			
 		return view;
 	}
 	
 	//개인 데이터 삭제
 	@RequestMapping("deletePersonalData.dvn")
 	public String deletePersonalNoteData(@RequestParam int dataseq,
 										@RequestParam int strgseq){
 		personalDataService.deletePersonalData(dataseq);
 		return "redirect:showPersonalDataList.dvn?strgseq="+strgseq;	
 	}
 	
}