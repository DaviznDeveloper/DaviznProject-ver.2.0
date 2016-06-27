package kr.or.davizn.datasetController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datainfoService.CommonDataService;
import kr.or.davizn.datainfoService.PersonalService;
import kr.or.davizn.datasetDTO.PersonaldataSchDTO;
import kr.or.davizn.datasetService.ScheduleService;

@Controller
@RequestMapping("/schedule/")
public class ScheduleController {
	
	@Autowired
	ScheduleService schservice;
	@Autowired
	PersonalService personalService;
	@Autowired
	CommonDataService commonService;
	
	//일정 리스트 가기
	@RequestMapping("goScheduleList.dvn")
	@Transactional
	public String goScheduleList(@RequestParam int strgseq,Model model){
		
		List<PersonaldataSchDTO> clist = schservice.currentSchedule(strgseq);
		List<PersonaldataSchDTO> elist = schservice.endSchedule(strgseq);
		
		model.addAttribute("clist", clist);
		model.addAttribute("elist", elist);
		model.addAttribute("strgseq",strgseq);
		
		return "datamanage.data-calendar-create";
		
	}
	
	//일정 데이터 만들기
	@RequestMapping("createSchedule.dvn")
	@Transactional
	public String createSchedule(PersonalDataDTO personaldto,PersonaldataSchDTO schedule,Model model){
		personalService.addPersonalData(personaldto);
		int dataseq = personalService.getDataseq(personaldto.getStrgseq());
		commonService.addDataseq(dataseq);
		schservice.addSchedule(schedule);
		
		return "redirect:/schedule/detailSchedule.dvn?dataseq=" + dataseq;
	
	}
	
	//일정 데이터 상세보기
	@RequestMapping("detailSchedule.dvn")
	public String detailSchedule(int dataseq, Model model){
		PersonaldataSchDTO schedule = schservice.detailSchedule(dataseq);
		model.addAttribute("schedule", schedule);
		return "datamanage.data-calendar-detail";
	}
	
	//일정 데이터 수정하기
	@RequestMapping("updateSchedule.dvn")
	public String updateSchedule(String dataname,int dataseq,PersonaldataSchDTO schedule){
		personalService.updatePersonaldata(dataseq, dataname);
		int result = schservice.updateSchedule(schedule);
		return "redirect:detailSchedule.dvn?dataseq="+dataseq;
	}
	
	
}
