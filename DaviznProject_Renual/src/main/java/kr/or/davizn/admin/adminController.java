package kr.or.davizn.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin/")
public class adminController {

	//@Autowired
	//SiteStatisticsService siteStatisticsService;
	
	@RequestMapping("site-statistics.dvn")
	public String moveSiteStatistics(Model model) {
		//model.addAttribute("strgseq", strgseq);
		return "admin.site-statistics";
	}
	
}
