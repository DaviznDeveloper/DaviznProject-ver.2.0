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
	
	/*@RequestMapping("addShareData.dvn")
	public String addShareData(@RequestParam int dataseq, @RequestParam int datatype, @RequestParam int groupseq, Principal principal){
		System.out.println("addShareData.dvn 컨트롤러 시작");
		GroupShareDataDTO groupsharedto = new GroupShareDataDTO();
		groupsharedto.setDataseq(dataseq);
		groupsharedto.setDatatype(datatype);
		groupsharedto.setUserid(principal.getName());
		groupshareService.addShareData(groupsharedto);
		return "redirect:/group/goGroupList.dvn?groupseq="+groupsharedto.getGroupseq();
	}*/
	
	@RequestMapping("addShareData.dvn")
	public String addShareData(@RequestParam int dataseq, @RequestParam int datatype, Principal principal){
		System.out.println("addShareData.dvn 컨트롤러 시작");
		System.out.println("dataseq : " + dataseq +"datatype : " + datatype);
		GroupShareDataDTO groupsharedto = new GroupShareDataDTO();
		
		return "group.group-data-list";
	}
	
	@RequestMapping("modifyNote.dvn")
	public String modifyNote(){
		return "";
	}
	
	@RequestMapping("deletleNote.dvn")
	public String deleteNote(){
		return "";
	}
}
