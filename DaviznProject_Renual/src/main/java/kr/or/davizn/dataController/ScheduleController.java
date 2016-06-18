package kr.or.davizn.dataController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/schedule/")
public class ScheduleController {
	
	//일정 데이터 만들기
	@RequestMapping("goScheduleList.dvn")
	public String goScheduleList(@RequestParam int strgseq){
		return "datamanage.data-calendar-create";
	}
	
	
	@RequestMapping("createSchedule.dvn")
	public String createSchedule(){
		return null;
	}
}
