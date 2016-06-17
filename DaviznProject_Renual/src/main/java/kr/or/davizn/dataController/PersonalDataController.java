package kr.or.davizn.dataController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataDTO.PersonalDataNoteDTO;
import kr.or.davizn.dataService.NoteService;
import kr.or.davizn.dataService.PersonalService;

@Controller
@RequestMapping("/personalData/")
public class PersonalDataController {

   @Autowired
   private PersonalService personalDataService;
  
   
   //데이터 리스트 보기
   @RequestMapping("showPersonalDataList.dvn")
   public String showPersonalDataList(Model model, int strgseq){
	   System.out.println("데이터 리스트 등장");
      List<PersonalDataDTO> list = personalDataService.showPersonalDataList(strgseq);
      model.addAttribute("pdatalist", list);
      model.addAttribute("strgseq",strgseq);
      return "datamanage.data-list";
   }
   
   //개인 데이터에 노트 데이터 추가하기
 	@RequestMapping("addPersonalNoteData.dvn")
 	public String addPersonalData(Model model,PersonalDataDTO pdata, 
 			@RequestParam String inputArticleContents,Principal principal,
 			HttpServletRequest request) throws IOException{
 		
 		String result = personalDataService.addPersonalData(pdata,inputArticleContents,principal,request);
 		return "redirect:/note/addNoteData.dvn?filepath="+result;
 	}
 	
 	//개인 데이터 상세보기
 	@RequestMapping("detailPersonalData.dvn")
 	public String detailPersonalData(@RequestParam int datatype,
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
 			view = "redirect:/goal/detailGoal.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
 		}else if(datatype==4){
 			//일정 상세보기
 			
 		}else{
 			
 		}
 			
 		return view;
 	}
 	
 	//개인 데이터 삭제
 	@RequestMapping("deletePersonalNoteData.dvn")
 	public String deletePersonalNoteData(@RequestParam int dataseq,
 										@RequestParam int strgseq){
 		int pdataResult = personalDataService.deleteNote(dataseq);
 		return "redirect:showPersonalDataList.dvn?strgseq="+strgseq;
 		
 	}
 	//개인 데이터 업데이트
 	@RequestMapping("updatePersonalNoteData.dvn")
 	public String updatePersonalNoteData(@RequestParam int dataseq,
 										@RequestParam String dataname){
 		
 		int result = personalDataService.updatePersonaldata(dataseq, dataname);
 		return "redirect:/note/detailNote.dvn?dataseq="+dataseq;
 	}
 	
 	@RequestMapping("deleteGoalData.dvn")
 	public String deleteGoalData(@RequestParam int dataseq,
 								@RequestParam int strgseq){
 		int result = personalDataService.deleteNote(dataseq);
 		return "redirect:showPersonalDataList.dvn?strgseq="+strgseq;
 	}
 	
}