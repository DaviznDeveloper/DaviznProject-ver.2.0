package kr.or.davizn.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.model.dto.NoteDTO;
import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.PersonalDataNoteDTO;
import kr.or.davizn.model.dto.UserStrgDTO;
import kr.or.davizn.service.NoteData;
import kr.or.davizn.service.PersonalData;

@Controller
@RequestMapping("/personalData/")
public class PersonalDataController {

   @Autowired
   private PersonalData personalDataService;
   
   @Autowired
   private NoteData notedataService;
   
   //데이터 리스트 보기
   @RequestMapping("showPersonalDataList.dvn")
   public String showPersonalDataList(Model model, int strgseq){
      List<PersonalDataDTO> list = personalDataService.showPersonalDataList(strgseq);
      model.addAttribute("pdatalist", list);
      model.addAttribute("strgseq",strgseq);
      return "datamanage.data-list";
   }
   
   //개인 데이터 추가하기
 	@RequestMapping("addPersonalData.dvn")
 	public String addPersonalData(Model model,PersonalDataDTO pdata, 
 			@RequestParam String inputArticleContents,Principal principal,
 			HttpServletRequest request) throws IOException{
 		
 		String result = personalDataService.addPersonalData(pdata,inputArticleContents,principal,request);
 		
 		return "redirect:addNoteData.dvn?filepath="+result;
 	}
 	
 	//note데이터 추가하기
 	@RequestMapping("addNoteData.dvn")
 	public String addNoteData(@RequestParam String filepath){
 		
 		int result = notedataService.addNoteData(filepath);
 
 		return "redirect:detailNoteData.dvn";
 	}
 	
 	//note 데이터 상세 조회
 	@RequestMapping("detailNoteData.dvn")
 	public String detailNoteData(Model model, HttpServletRequest request) 
 			throws IOException{
 		PersonalDataNoteDTO note =notedataService.detailNoteData(request);
 		model.addAttribute("note", note);
 		return "datamanage.data-note-detail";
 	}
 	
 	
 	
}