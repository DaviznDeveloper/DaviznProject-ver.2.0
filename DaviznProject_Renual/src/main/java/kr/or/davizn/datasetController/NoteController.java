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
import kr.or.davizn.datainfoService.GroupDataService;
import kr.or.davizn.datainfoService.PersonalService;
import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;
import kr.or.davizn.datasetService.NoteService;
import kr.or.davizn.groupDTO.VersionDTO;
import kr.or.davizn.groupService.GroupInfoService;
import kr.or.davizn.groupService.VersionService;

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
	@Autowired
	GroupDataService groupdataService;
	@Autowired
	VersionService versionService;
	
	// data-list.jsp에서 modal 창을 통한 노트 데이터 추가하기 창으로 이동.
	@RequestMapping("moveNoteCreate.dvn")
	public String moveNoteCreate(Model model, int strgseq) {
		model.addAttribute("strgseq", strgseq);
		return "datamanage.data-note-create";
	}
	

	@RequestMapping("modifyGroupNote.dvn")
	   public String modify(HttpServletRequest request,VersionDTO versiondto,
			   GroupDataDTO groupdatadto,Principal principal,Model model) throws IOException{
		   
	      int dataseq = versiondto.getDataseq();
	      int datatype = groupdatadto.getDatatype();
	      int groupseq = groupdataService.getOneGroupData(dataseq).getGroupseq();
	      String datahtml = versiondto.getDatahtml();
	      String fileName = commonService.getFileName(principal.getName());
	      String userid = principal.getName();

	      versiondto.setUserid(userid);
	      versiondto.setGroupseq(groupseq);
	      versiondto.setFilename(fileName);
	      commonService.makeFile(datatype, datahtml, userid, request, fileName);
	      groupdataService.updateGroupdata(groupdatadto);
	      notedataService.modifyNoteFile(dataseq, request, datahtml);
	      PersonalDataNoteDTO note = notedataService.detailNote(request, dataseq);
	      model.addAttribute("datahtml", datahtml);
	      model.addAttribute("dataname", note.getDataname());
	      model.addAttribute("userid", userid);
	      model.addAttribute("datacreate", note.getDatacreate());
	      model.addAttribute("dataseq", note.getDataseq());
	      
	      return "group.group-data-share-history";
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
		
/*		PersonalDataNoteDTO notedto = notedataService.detailNote(request, dataseq);
*/		return "redirect:/note/detailNote.dvn?dataseq="+dataseq+"&function=d";
	}
	
	// 노트 데이터 수정(실제 DB update)
	//@RequestMapping("modifyNoteAction_Group.dvn")
}