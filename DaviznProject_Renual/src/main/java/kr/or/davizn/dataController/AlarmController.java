package kr.or.davizn.dataController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlarmController {

	@RequestMapping("alarmList.dvn")
	public String alarms(Model model){
		
		return null;
	}
}
