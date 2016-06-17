package kr.or.davizn.dataController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.dataDTO.PersonalDataNoteDTO;
import kr.or.davizn.dataService.NoteService;

@Controller
@RequestMapping("/note/")
public class NoteController{
	
	@Autowired
	NoteService notedataService;
	
	//노트 데이터 추가하기
	@RequestMapping("addNoteData.dvn")
 	public String addNoteData(@RequestParam String filepath){
 		
 		int result = notedataService.addNoteData(filepath);
 		return "redirect:detailNoteData.dvn";
 	}
	
	//note 데이터 상세 조회
 	@RequestMapping("detailNoteData.dvn")
 	public String detailNoteData(Model model, HttpServletRequest request) 
 			throws IOException{
 		PersonalDataNoteDTO note=notedataService.detailNoteData(request);
 		model.addAttribute("note", note);
 		return "datamanage.data-note-detail";
 	}
	
	//목록에서 note 데이터 상세조회
	 	@RequestMapping("detailNote.dvn")
	 	public String detailNote(@RequestParam int dataseq,
	 							 Model model, HttpServletRequest request) throws IOException{
	 		
	 		PersonalDataNoteDTO note = notedataService.detailNote(request, dataseq);
	 		model.addAttribute("note", note);
	 		return "datamanage.data-note-detail";
	 	}
	 	
	 	//상세 화면에서 데이터 수정 창 이동(기존 정보 확인)
	 	@RequestMapping("modifyNote.dvn")
	 	public String modifyNote(@RequestParam int dataseq,
	 							 @RequestParam int strgseq,
	 							 HttpServletRequest request,
	 							 Model model) 
	 									 throws IOException{
	 		PersonalDataNoteDTO note = notedataService.modifyNote(dataseq,request);
	 		model.addAttribute("note", note);
	 		return "datamanage.data-note-modi";
	 	}
	 	
	 	//노트 데이터 수정(실제 DB update)
	 	@RequestMapping("modifyNoteAction.dvn")
	 	public String modifyNoteAction(@RequestParam int dataseq,
				 					   @RequestParam int strgseq,
				 					   @RequestParam String dataname,
				 					   @RequestParam String inputArticleContents,
				 					   HttpServletRequest request
				 					   ) throws IOException{
	 		
	 		notedataService.modifyNoteFile(dataseq, request, inputArticleContents);
	 		return "redirect:/personalData/updatePersonalNoteData.dvn?dataseq="+dataseq+"&dataname="+dataname;
	 		
	 		
	 	}
	 	
	 	//상세 화면에서 데이터 삭제
	 	@RequestMapping("deleteNote.dvn")
	 	public String deleteNote(@RequestParam int dataseq,
	 							 @RequestParam int strgseq){
	 		
	 		int noteResult = notedataService.deleteNote(dataseq);
	 		return "redirect:/personalData/deletePersonalNoteData.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
	 		
	 	}
	 	
	 	
	
	
	
}
