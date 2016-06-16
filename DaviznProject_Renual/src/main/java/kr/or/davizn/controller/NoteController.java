package kr.or.davizn.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.model.dto.PersonalDataNoteDTO;
import kr.or.davizn.service.NoteData;

@Controller
@RequestMapping("/note/")
public class NoteController{
	
	@Autowired
	private NoteData notedataService;
	
	@RequestMapping("addNoteData.dvn")
 	public String addNoteData(@RequestParam String filepath){
 		
 		int result = notedataService.addNoteData(filepath);
 
 		return "redirect:/note/detailNoteData.dvn";
 	}
	
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
	
	
	
}
