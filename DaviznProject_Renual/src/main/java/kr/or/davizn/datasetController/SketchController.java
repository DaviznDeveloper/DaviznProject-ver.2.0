package kr.or.davizn.datasetController;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datainfoInterface.PersonalDataDAO;
import kr.or.davizn.datainfoService.CommonDataService;
import kr.or.davizn.datainfoService.PersonalService;
import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;
import kr.or.davizn.datasetDTO.PersonalDataSketchDTO;
import kr.or.davizn.datasetService.SketchService;

@Controller
@RequestMapping("/sketch/")
public class SketchController {
	
	@Autowired
	SketchService sketchservice;
	@Autowired
	PersonalService personalService;
	@Autowired
	CommonDataService commonService;
	
	// 스케치 창 이동
	@RequestMapping("moveSketchCreate.dvn")
	public String moveNoteCreate(Model model, int strgseq) {
		model.addAttribute("strgseq", strgseq);
		return "datamanage.data-sketch-create";
	}
	

	//스케치 데이터 파일 만들기
	@RequestMapping("addSketchData.dvn")
	@Transactional
	public String writeSketchData(PersonalDataDTO personaldto, PersonalDataSketchDTO sketchdto
								,Principal principal, HttpServletRequest request) 
										throws IOException{
		
		personalService.addPersonalData(personaldto);
		
		int dataseq = personalService.getDataseq(personaldto.getStrgseq());
		String filepath = commonService.getFileName(principal.getName());
		sketchdto.setFilepath(filepath);
		commonService.makeFile(sketchdto.getDatatype(), sketchdto.getDatahtml(), principal.getName(), request, filepath);
		sketchservice.addSketchData(sketchdto);
		return "redirect:/sketch/detailsketch.dvn?dataseq=" + dataseq +"&function=d";
	}
	
	@RequestMapping("detailsketch.dvn")
	public String detailNote(@RequestParam int dataseq, Model model, 
							HttpServletRequest request, @RequestParam String function) throws IOException {
		PersonalDataSketchDTO sketch = sketchservice.detailSketch(dataseq, request);
		model.addAttribute("sketch", sketch);
		if(function.equals("d")) return "datamanage.data-sketch-detail";
		else if(function.equals("m")) return "datamanage.data-sketch-modi";
		else return "datamanage.data-sketch-detail";
	}

	
	@RequestMapping("modifySketch.dvn")
	@Transactional
	public String ModifySketchAction(PersonalDataDTO personaldataDTO,
									@RequestParam String datahtml,
									HttpServletRequest request) throws IOException{

		int dataseq = personaldataDTO.getDataseq();
		String dataname = personaldataDTO.getDataname();
		sketchservice.modifySketch(dataseq, request, datahtml);
		personalService.updatePersonaldata(dataseq, dataname);
		return "redirect:/sketch/detailsketch.dvn?dataseq="+dataseq+"&function=d";
	}
	
	
	
}
