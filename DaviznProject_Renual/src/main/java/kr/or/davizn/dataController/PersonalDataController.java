package kr.or.davizn.dataController;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataDTO.UserStrgDTO;
import kr.or.davizn.dataService.PersonalService;
import kr.or.davizn.dataService.UserStrgService;
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
   
   //데이터의 모든 내용을 생성, 수정시 file로 저장하는 기능. 
   @RequestMapping("managefile.dvn")
	public @ResponseBody String testtest(@RequestParam String datahtml,Model model, PersonalDataDTO personaldto,
			Principal principal, HttpServletRequest request) throws IOException{
	   
	   //파일로...
		String result = URLDecoder.decode(datahtml);
		String filepath = personalDataService.getFileName(personaldto, result, principal, request);
		return result;
	}
   
   
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
 			view ="redirect:/note/detailNote.dvn?dataseq="+dataseq+"&strgseq="+strgseq+"&function=d";
 		}else if(datatype==2){
 			//스케치 상세 보기
 			view ="redirect:/sketch/detailsketch.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
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
 		
 		int pdataResult = personalDataService.deleteNote(dataseq);
 		return "redirect:showPersonalDataList.dvn?strgseq="+strgseq;	
 	}
 	
 	
/*<<<<<<< HEAD*/
 	/*//데이터 리스트에서 수정하기
 	@RequestMapping("modifyPersonalData.dvn")
 	public String modifyPersonalData(@RequestParam int datatype,
 									 @RequestParam int strgseq,
 									 @RequestParam int dataseq){
 		String view = null;
 		if(datatype==1){
 			//노트 데이터 상세 보기
 			view ="redirect:/note/detailNote.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
 		}else if(datatype==2){
 			//스케치 상세 보기
 			
 		}else if(datatype==3){
 			//목표 상세 보기
 			view = "redirect:/goal/updatePersonalNoteData.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
 		}else if(datatype==4){
 			//일정 상세보기
 			
 		}else{
 			
 		}
 			
 		return view;
 	}*/
 	
 	
 	
/* 	//노트 데이터 업데이트
 	@RequestMapping("updatePersonalNoteData.dvn")
=======*/
 	//데이터 제목 변경을 위한 modify. personaldata 테이블.
 	@RequestMapping("updatePersonalData.dvn")
/*>>>>>>> branch 'master' of https://github.com/DaviznDeveloper/DaviznProject-ver.2.0
*/ 	public String updatePersonalNoteData(@RequestParam int dataseq,
 										@RequestParam String dataname,
 										@RequestParam int datatype,
 										@RequestParam int strgseq){
 		int result = personalDataService.updatePersonaldata(dataseq, dataname);
 		
 		return "redirect:/personalData/detailPersonalData.dvn?datatype="+datatype +"&dataseq="+dataseq+"&strgseq="+strgseq;
 	}

 	
}