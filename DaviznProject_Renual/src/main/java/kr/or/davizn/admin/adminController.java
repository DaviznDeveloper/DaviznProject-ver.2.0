package kr.or.davizn.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.or.davizn.adminDTO.LineChartDTO;
import kr.or.davizn.adminDTO.PieChartDTO;
import kr.or.davizn.adminService.AdminService;



@Controller
@RequestMapping("/admin/")
public class adminController {

	@Autowired
	AdminService adminservice;
	
	//통계 페이지 이동
	@RequestMapping("site-statistics.dvn")
	public String moveSiteStatistics(Model model) {
		
		//총 회원의 수
		int membercount = adminservice.membercount();
		//회원이 생성한 데이터의 수
		int datacount = adminservice.datacount();
		//회원이 생성한 그룹의 수
		int groupcount = adminservice.groupcount();
		
		//페이지 로딩되면 뿌려지는 파이 차트 일 별 조회
		List<PieChartDTO> dailyPieChart = adminservice.dailyPieChart();
		//페이지 로딩되면 뿌려지는  라인 차트 일 별 조회
		List<LineChartDTO> dailyLineChart = adminservice.dailyLineChart();
		
		Gson gson = new Gson();
		String json = gson.toJson(dailyLineChart);
		System.out.println("json 변환");
		System.out.println(json);
		
		
		model.addAttribute("membercount", membercount);
		model.addAttribute("datacount", datacount);
		model.addAttribute("groupcount", groupcount);
		model.addAttribute("dailyPieChart", dailyPieChart);
		model.addAttribute("dailyLineChart", json);
		
		return "admin.site-statistics";
	}
	
	//파이 차트 주별 조회
	@RequestMapping("weekPiechart.dvn")
	public @ResponseBody List<PieChartDTO> weekPieChart(){
		List<PieChartDTO> weekPieChart = adminservice.weekPieChart();
		return weekPieChart;
	}
	//파이 차트 일별 조회
	@RequestMapping("dailyPieChart.dvn")
	public @ResponseBody List<PieChartDTO> dailyPieChart(){
		List<PieChartDTO> dailyPieChart = adminservice.dailyPieChart();
		return dailyPieChart;
	}
	//파이 차트 월별 조회
	@RequestMapping("monthPieChart.dvn")
	public @ResponseBody List<PieChartDTO> monthPieChart(){
		List<PieChartDTO> monthPieChart = adminservice.monthPieChart();
		return monthPieChart;
	}
	
	//일별 라인 차트 조회
	@RequestMapping("dailyLineChart.dvn")
	public @ResponseBody List<LineChartDTO> dailyLineChart(){
		List<LineChartDTO> dailyLineChart = adminservice.dailyLineChart();
		return dailyLineChart;
	}
	
	//주별 라인 차트 조회
	@RequestMapping("weeklyLineChart.dvn")
	public @ResponseBody List<LineChartDTO> weeklyLineChart(){
		List<LineChartDTO> weeklyLineChart = adminservice.weeklyLineChart();
		return weeklyLineChart;
	}
	
	//월별 라인 차트 조회
	@RequestMapping("monthlyLineChart.dvn")
	public @ResponseBody List<LineChartDTO> monthlyLineChart(){
		List<LineChartDTO> monthlyLineChart = adminservice.monthlyLineChart();
		return monthlyLineChart;
	}
	
	
	
	
	
	
	
}
