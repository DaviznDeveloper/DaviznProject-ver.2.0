package kr.or.davizn.dataController;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataDTO.PersonalDataNoteDTO;
import kr.or.davizn.dataService.NoteService;
import kr.or.davizn.dataService.PersonalService;

@Controller
@RequestMapping("/note/")
public class NoteController {

	@Autowired
	NoteService notedataService;
	@Autowired
	PersonalService personalService;

	// data-list.jsp에서 modal 창을 통한 노트 데이터 추가하기 창으로 이동.
	@RequestMapping("moveNoteCreate.dvn")
	public String moveNoteCreate(Model model, int strgseq) {
		model.addAttribute("strgseq", strgseq);
		return "datamanage.data-note-create";
	}

	// 노트 데이터 추가를 위해 personaldata 테이블에 insert
	@RequestMapping("addPersonalNoteData.dvn")
	public String addPersonalData(Model model, PersonalDataDTO personaldto, @RequestParam String datahtml,
			Principal principal, HttpServletRequest request) throws IOException {

		String filepath = personalService.getFileName(personaldto, datahtml, principal, request);
		personalService.addPersonalData(personaldto);
		int strgseq = personaldto.getStrgseq();
		int dataseq = personalService.getDataseq(strgseq);
		personalService.manageFile(dataseq,filepath);
		return "redirect:/note/addNoteData.dvn?filepath=" + filepath + "&strgseq=" + strgseq;
	}

	// 노트 데이터 추가를 위해 note 테이블에 insert
	@RequestMapping("addNoteData.dvn")
	public String addNoteData(@RequestParam String filepath, @RequestParam int strgseq) {

		int result = notedataService.addNoteData(filepath);
		int dataseq = personalService.getDataseq(strgseq);
		return "redirect:/note/detailNote.dvn?dataseq=" + dataseq +"&function=d";
	}

	// 목록에서 note 데이터 상세조회
	@RequestMapping("detailNote.dvn")
	public String detailNote(@RequestParam int dataseq, Model model, 
							HttpServletRequest request, @RequestParam String function) throws IOException {
		PersonalDataNoteDTO note = notedataService.detailNote(request, dataseq);
		model.addAttribute("note", note);
		if(function.equals("d")) return "datamanage.data-note-detail";
		else if(function.equals("m")) return "datamanage.data-note-modi";
		else return "datamanage.data-note-detail";
	}

	// 노트 데이터 수정(실제 DB update)
	@RequestMapping("modifyNoteAction.dvn")
	public String modifyNoteAction(PersonalDataDTO personaldataDTO,
			@RequestParam String inputArticleContents, HttpServletRequest request) throws IOException {
		int dataseq = personaldataDTO.getDataseq();
		int datatype = personaldataDTO.getDatatype();
		int strgseq = personaldataDTO.getStrgseq();
		String dataname = personaldataDTO.getDataname();
		notedataService.modifyNoteFile(dataseq, request, inputArticleContents);
		return "redirect:/personalData/updatePersonalData.dvn?dataseq=" + dataseq + "&dataname=" + dataname + "&datatype="+datatype+"&strgseq="+strgseq;

	}
}
