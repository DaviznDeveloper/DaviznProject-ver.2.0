package kr.or.davizn.etcController;

import java.security.Principal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.etcService.Alarm;

@Controller
@RequestMapping("/alarm/")
public class AlarmController {
	@Autowired
	private Alarm alarmService;
	
	//알람 리스트
	@RequestMapping("alarmList.dvn")
	public String alarms(Model model,Principal userid) throws ClassNotFoundException, SQLException{
		System.out.println("욜로 옴");
		System.out.println("userid : "+userid.getName());
		alarmService.alarmList(userid, model);
		return "Alarm.alarmList";
	}
	
	//선택 알람 삭제하기
	@RequestMapping("selectOne.dvn")
	public String deleteOne(int alarmseq)throws ClassNotFoundException, SQLException{
		alarmService.deleteOne(alarmseq);
		return "redirect:/alarm/alarmList.dvn";
	}
	
	//알람 전부 삭제
	@RequestMapping("allDelete.dvn")
	public String deleteAll(Principal userid) throws ClassNotFoundException, SQLException{
		System.out.println("userid +"+userid);
		alarmService.allDelete(userid);
		return "redirect:/alarm/alarmList.dvn";
	}
	
	//읽은 알림 삭제
	@RequestMapping("readDelete.dvn")
	public String readDelete(Principal userid) throws ClassNotFoundException, SQLException{
		System.out.println("마지막 딜리트!");
		alarmService.readThings(userid);
		return "redirect:/alarm/alarmList.dvn";
	}
}
