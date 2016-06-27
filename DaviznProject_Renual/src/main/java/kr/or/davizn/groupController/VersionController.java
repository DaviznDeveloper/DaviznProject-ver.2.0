package kr.or.davizn.groupController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.datasetService.NoteService;
import kr.or.davizn.groupDTO.VersionDTO;
import kr.or.davizn.groupService.VersionService;

@Controller
@RequestMapping("/version/")
public class VersionController {
	
	@Autowired
	VersionService versionService;

	@RequestMapping("showVerionlist")
	public String showVersionlist(Model model, int dataseq){
		List<VersionDTO> versionlist = versionService.getVersionlist(dataseq);
		for(VersionDTO dto:versionlist){
			System.out.println(dto.getDataseq());
		}
		model.addAttribute("versionlist",versionlist);
		return "group.group-data-share-history";
	}
}
