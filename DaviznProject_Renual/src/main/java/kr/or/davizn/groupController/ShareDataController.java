package kr.or.davizn.groupController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.groupDTO.GroupShareDataDTO;
import kr.or.davizn.groupService.GroupShareDataService;

@Controller
@RequestMapping("/sharedata/")
public class ShareDataController {
	
	@Autowired
	GroupShareDataService groupshareService;
	
	@RequestMapping("addShareData.dvn")
	public String addShareData(GroupShareDataDTO groupsharedto, Principal principal){	
		/* 
		 * ***** 현재 groupsharedto가 갖고 있는 것 *********
		 * ***** dataseq, datatyep, groupseq, dataname *****
		 */
		
		groupsharedto.setUserid(principal.getName());
		//groupsharedto의 datatype에 따라 저장되는 내용이 달라짐. 
		//note는 file 경로, file 내용 복사 등...
		//sketch도 같다.
		//목표, 일정은 다르다.
		//앨범도 다르다.
		//Note : 1, 목표 : 3, 일정 : 4, 
		if(groupsharedto.getDatatype() == 1){
			//노트
		}else if(groupsharedto.getDatatype() == 2){
			
		}else if(groupsharedto.getDatatype() == 3){
			//목표
		}else if(groupsharedto.getDatatype() == 4){
			//일정
		}
		
		
		groupshareService.addShareData(groupsharedto);
		return "redirect:/group/showGroupDataList.dvn?groupseq=" + groupsharedto.getGroupseq();
	}
	
	@RequestMapping("datailShareNoteData.dvn")
	public String detailShareData(){
		System.out.println("datailShareNoteData.dvn 컨트롤러");
		
		return "group.group-data-share-note-detail";
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
