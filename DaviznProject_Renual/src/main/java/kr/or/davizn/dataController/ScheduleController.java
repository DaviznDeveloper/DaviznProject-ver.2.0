package kr.or.davizn.dataController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.dataDTO.PersonaldataSchDTO;
import kr.or.davizn.dataDTO.ScheduleDTO;
import kr.or.davizn.dataService.ScheduleService;

@Controller
@RequestMapping("/schedule/")
public class ScheduleController {
	
	@Autowired
	ScheduleService schservice;
	
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
	public String createSchedule(int strgseq, String dataname,ScheduleDTO schedule){
		schservice.addSchedule(strgseq, dataname, schedule);
		return "redirect:goScheduleList.dvn?strgseq="+strgseq;
	}
	
	//일정 데이터 상세보기
	@RequestMapping("detailSchedule.dvn")
	public String detailSchedule(int dataseq, Model model){
		PersonaldataSchDTO schedule = schservice.detailSchedule(dataseq);
		model.addAttribute("schedule", schedule);
		return "datamanage.data-calendar-detail";
	}
	
	//일정 데이터 삭제하기
	@RequestMapping("deleteSchedule.dvn")
	public String deleteSchedule(int dataseq,int strgseq){
		int result = schservice.deleteSchedule(dataseq);
		return "redirect:goScheduleList.dvn?strgseq="+strgseq;
	}
	
	//일정 데이터 수정하기
	@RequestMapping("updateSchedule.dvn")
	public String updateSchedule(String dataname,int dataseq,ScheduleDTO schedule){
		int result = schservice.updateSchedule(dataname, dataseq, schedule);
		return "redirect:detailSchedule.dvn?dataseq="+dataseq;
		
		
	}
	
	
}
