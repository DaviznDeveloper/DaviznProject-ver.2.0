package kr.or.davizn.datasetController;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.datainfoDTO.GroupDataDTO;
import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datainfoService.CommonDataService;
import kr.or.davizn.datainfoService.PersonalService;
import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;
import kr.or.davizn.datasetService.NoteService;
import kr.or.davizn.groupService.GroupInfoService;

@Controller
@RequestMapping("/note/")
public class NoteController {

	@Autowired
	NoteService notedataService;
	@Autowired
	PersonalService personalService;
	@Autowired
	CommonDataService commonService;
	@Autowired
	GroupInfoService groupinfoService;
	
	// data-list.jsp에서 modal 창을 통한 노트 데이터 추가하기 창으로 이동.
	@RequestMapping("moveNoteCreate.dvn")
	public String moveNoteCreate(Model model, int strgseq) {
		model.addAttribute("strgseq", strgseq);
		return "datamanage.data-note-create";
	}

	@RequestMapping("modify.dvn")
	public String modify(@RequestParam int dataseq,HttpServletRequest request,@RequestParam String datahtml) throws IOException{
		PersonalDataNoteDTO notedto = notedataService.detailNote(request, dataseq);
		GroupDataDTO groupdto = groupinfoService.getGroup(dataseq);
		String dataname = groupdto.getDataname();
		notedataService.modifyNoteFile(dataseq, request, datahtml);
		return "redirect:/version/addVersion.dvn?dataseq="+dataseq+"&groupseq="+groupdto.getGroupseq();
	}
	// 노트 데이터 추가
	@RequestMapping("addNoteData.dvn")
	@Transactional
	public String addPersonalData(Model model, PersonalDataDTO personaldto, PersonalDataNoteDTO notedto,
			Principal principal, HttpServletRequest request) throws IOException {
		
		personalService.addPersonalData(personaldto);
		
		int dataseq = personalService.getDataseq(personaldto.getStrgseq());
		String datahtml = notedto.getDatahtml();
		String filepath = commonService.getFileName(principal.getName());
		
		notedto.setDataseq(dataseq);
		notedto.setFilepath(filepath);
		commonService.makeFile(personaldto.getDatatype(), datahtml, principal.getName(), request,filepath);
		commonService.addDataseq(dataseq);
		notedataService.addNoteData(notedto);

		return "redirect:/note/detailNote.dvn?dataseq=" + dataseq +"&function=d";
	}

	// 목록에서 note 데이터 상세조회 (상세보기, 수정하기 클릭시)
	@RequestMapping("detailNote.dvn")
	public String detailNote(@RequestParam int dataseq, Model model, 
							HttpServletRequest request, @RequestParam String function) throws IOException {
		
		PersonalDataNoteDTO note = notedataService.detailNote(request, dataseq);
		model.addAttribute("note", note);
		if(function.equals("d")) {
			if(note.getOrigin().equals("personal"))return "datamanage.data-note-detail";
			else if(note.getOrigin().equals("group")) return "group.group-data-share-note-detail";
		}
		else if(function.equals("m")){
			if(note.getOrigin().equals("personal"))return "datamanage.data-note-modi";
			else if(note.getOrigin().equals("group")) return "group.group-data-share-note-modi";
		}
		return "datamanage.data-note-detail";
	}

	// 노트 데이터 수정(실제 DB update)
	@RequestMapping("modifyNoteAction.dvn")
	@Transactional
	public String modifyNoteAction(PersonalDataDTO personaldataDTO,
			@RequestParam String datahtml, HttpServletRequest request) throws IOException {
		
		int dataseq = personaldataDTO.getDataseq();
		String dataname = personaldataDTO.getDataname();
		notedataService.modifyNoteFile(dataseq, request, datahtml);
		personalService.updatePersonaldata(dataseq, dataname);
		
		PersonalDataNoteDTO notedto = notedataService.detailNote(request, dataseq);
		return "redirect:/note/detailNote.dvn?dataseq="+dataseq+"&function=d";
	}
	
	// 노트 데이터 수정(실제 DB update)
	//@RequestMapping("modifyNoteAction_Group.dvn")
}
