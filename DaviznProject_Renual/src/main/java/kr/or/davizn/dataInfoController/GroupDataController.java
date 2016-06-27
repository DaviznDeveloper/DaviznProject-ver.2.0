package kr.or.davizn.dataInfoController;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.datainfoDTO.GroupDataDTO;
import kr.or.davizn.datainfoService.CommonDataService;
import kr.or.davizn.datainfoService.GroupDataService;
import kr.or.davizn.datainfoService.PersonalService;
import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;
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
	@Autowired
	CommonDataService commonService;
	
	//그룹 공유하기 버튼 클릭했을 시
	@RequestMapping("addShareData.dvn")
	@Transactional
	public String addShareData(GroupDataDTO groupdatadto, Principal principal, HttpServletRequest request) throws IOException{	
		/* 
		 * ***** 현재 groupsharedto가 갖고 있는 것 *********
		 * ***** dataseq, datatype, groupseq, dataname *****
		 */
		int dataseq = groupdatadto.getDataseq();
		int groupseq = groupdatadto.getGroupseq();
		int datatype = groupdatadto.getDatatype();
		String dataname = groupdatadto.getDataname();
		String userid = principal.getName();
		
		groupdatadto.setUserid(userid);
		groupdataService.addGroupDataTable(groupdatadto);
		int g_dataseq = groupdataService.getG_dataseq(groupseq);
		commonService.addDataseq(g_dataseq);
		if(groupdatadto.getDatatype() == 1){
			PersonalDataNoteDTO notedto = noteService.detailNote(request, dataseq);
			String p_file = notedto.getFilepath();
			String g_file = commonService.getFileName(userid);
		
			groupdataService.copyFile(request,p_file, g_file,1);
			notedto.setDataseq(g_dataseq);
			notedto.setFilepath(g_file);
			notedto.setOrigin("group");
			noteService.addNoteData(notedto);
	
		}else if(groupdatadto.getDatatype() == 2){
			//스케치
		}else if(groupdatadto.getDatatype() == 3){
			//목표
		}else if(groupdatadto.getDatatype() == 4){
			//일정
		}
		return "redirect:/groupdata/showG_Datalist.dvn?groupseq="+groupseq;
	}
	
	@RequestMapping("showG_Datalist.dvn")
	public String showG_Datalist(Model model,@RequestParam int groupseq){
		List<GroupDataDTO> sharedatalist = groupdataService.getG_ShareDatalist(groupseq);
		model.addAttribute("sharedatalist",sharedatalist);
		return "group.group-data-list";
	}
	
	@RequestMapping("datailData.dvn")
	public String detailShareData(GroupDataDTO groupdata){
		int datatype = groupdata.getDatatype();
		int dataseq = groupdata.getDataseq();
		if(datatype==1){return "redirect:/note/detailNote.dvn?dataseq=" + dataseq +"&function=d";}
		else if(datatype==2){return "redirect:/sketch/detailsketch.dvn";}
		else if(datatype==3){return "redirect:/goal/detailGoal.dvn";}
		else {return "redirect:/schedule/detailSchedule.dvn";}
	}
	
	@RequestMapping("modifyShareData.dvn")
	public String modifyShareData(int dataseq){
		return "redirect:/note/detailNote.dvn?dataseq=" + dataseq +"&function=m";
	}
	
	@RequestMapping("deletleShareData.dvn")
	public String deleteShareData(int dataseq){
		groupdataService.deleteGroupDataTable(dataseq);
		commonService.deleteDataseq(dataseq);
		return "";
	}
}
