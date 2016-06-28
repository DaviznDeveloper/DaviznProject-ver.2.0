package kr.or.davizn.groupController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.datasetService.NoteService;
import kr.or.davizn.groupService.VersionService;

@Controller
@RequestMapping("/version/")
public class VersionController {
	
	@Autowired
	VersionService versionService;
	@Autowired
	NoteService noteService;

	@RequestMapping("addVersion")
	public void addVersion(){
		
	}
}
