package kr.or.davizn.groupController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;
import kr.or.davizn.datasetService.NoteService;
import kr.or.davizn.groupDTO.VersionDTO;
import kr.or.davizn.groupService.VersionService;

@Controller
@RequestMapping("/version/")
public class VersionController {
	
	@Autowired
	VersionService versionService;
	@Autowired
	NoteService noteService;
	
	
	@RequestMapping("addVersion.dvn")
	public String addVersion(int dataseq,int groupseq, HttpServletRequest request) throws IOException{
		PersonalDataNoteDTO notedto = noteService.detailNote(request, dataseq);
		String filename = notedto.getFilepath();
		VersionDTO versiondto = new VersionDTO();
		versiondto.setDataseq(dataseq);
		versiondto.setGroupseq(groupseq);
		versiondto.setFilename(filename);
		versionService.addVersion(versiondto);
		return "redirect:/groupdata/datailData.dvn?datatype=1&dataseq="+dataseq;
	}
}
