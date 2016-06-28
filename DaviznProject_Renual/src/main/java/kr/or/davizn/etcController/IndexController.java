package kr.or.davizn.etcController;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.etcService.Alarm;
import kr.or.davizn.messageController.MessageController;

@Controller
public class IndexController {

	@Autowired
	private Alarm alarm;

	@Autowired
	private MessageController msgcontroller;
	


	@RequestMapping("index.dvn")
	public String moveIndex(Principal principal){
		if(principal ==null){return "home.index";}
		return "redirect:index2.dvn?userid=" + principal.getName(); 
	}
	
	@RequestMapping("index2.dvn")
	public String moveIndex2(String userid,Model model,HttpSession session) throws Exception{
		System.out.println("index2.dvn 에 들어옴");
		System.out.println(userid);

		int result=alarm.getCount(userid);
		
		int total= msgcontroller.getMessageCount(userid);
		 
		session.setAttribute("userid", userid);
		session.setAttribute("alarmList", alarm.showAlarmList(userid, model));
		session.setAttribute("alarmCount", result);
		
		session.setAttribute("msgCount", total);

		session.setAttribute("armCount", result);

		return "home.index"; //select 시키면 됨
	}
	
}
