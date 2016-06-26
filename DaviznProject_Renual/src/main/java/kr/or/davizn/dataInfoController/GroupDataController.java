package kr.or.davizn.dataInfoController;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.datainfoDTO.GroupDataDTO;
import kr.or.davizn.datainfoService.GroupDataService;
import kr.or.davizn.datainfoService.PersonalService;
import kr.or.davizn.datasetService.NoteService;

@Controller
@RequestMapping("/groupdata/")
public class GroupDataController {
	
	@Autowired
	GroupDataService groupdataService;
	@Autowired
	PersonalService personalService;
	@Autowired
	NoteService noteService;
	
	//그룹 공유하기 버튼 클릭했을 시
	@RequestMapping("addShareData.dvn")
	public String addShareData(GroupDataDTO groupdatadto, Principal principal, HttpServletRequest request) throws IOException{	
		/* 
		 * ***** 현재 groupsharedto가 갖고 있는 것 *********
		 * ***** dataseq, datatype, groupseq, dataname *****
		 */
		
		groupdatadto.setUserid(principal.getName());
		groupdatadto.setOrigin("p");
		groupdataService.addGroupDataTable(groupdatadto);
		
		/*if(groupdatadto.getDatatype() == 1){
			
			NoteDTO g_notedto = new NoteDTO();
			String p_file = noteService.detailNote(request, groupdatadto.getDataseq()).getFilepath();
			String g_file = personalService.getFileName(principal.getName()); 
			
			groupdataService.copyFile(request,p_file, g_file,1);
			g_notedto.setFilepath(g_file);
			g_notedto.setDataseq(groupdataService.getG_dataseq(groupdatadto.getGroupseq()));
			
			groupdataService.addNote(g_notedto);
		
		}else if(groupdatadto.getDatatype() == 2){
			//스케치
		}else if(groupdatadto.getDatatype() == 3){
			//목표
		}else if(groupdatadto.getDatatype() == 4){
			//일정
		}*/
		return "redirect:/groupdata/showG_Datalist.dvn?groupseq="+groupdatadto.getGroupseq();
	}
	
	@RequestMapping("showG_Datalist.dvn")
	public String showG_Datalist(Model model,@RequestParam int groupseq){
		/*List<GroupDataDTO> sharedatalist = groupdataService.getG_ShareDatalist(groupseq);
		model.addAttribute("sharedatalist",sharedatalist);*/
		return "group.group-data-list";
	}
	
	@RequestMapping("datailData.dvn")
	public String detailShareData(int datatype){
		if(datatype==1){return "redirect:/G_note/datailNoteData.dvn";}
		else if(datatype==2){return "redirect:/G_Sketch/datailSketchData.dvn";}
		else if(datatype==3){return "redirect:/G_Goal/datailGoalData.dvn";}
		else {return "redirect:/G_Schedule/datailScheduleData.dvn";}
	}
	
	@RequestMapping("modifyShareData.dvn")
	public String modifyShareData(){
		return "";
	}
	
	@RequestMapping("deletleShareNote.dvn")
	public String deleteShareData(){
		return "";
	}
}
