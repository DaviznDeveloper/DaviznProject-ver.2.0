package kr.or.davizn.adminService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.adminDTO.LineChartDTO;
import kr.or.davizn.adminDTO.PieChartDTO;
import kr.or.davizn.adminInterface.AdminDAO;

@Service
public class AdminService {
	
	@Autowired
	SqlSession sqlsession;
	
	//총 회원의 수
	public int membercount(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		int membercount = admindao.membercount();
		return membercount;
	}
	//회원이 생성한 데이터의 개수
	public int datacount(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		int datacount = admindao.datacount();
		return datacount;
	}
	//회원이 생성한 그룹의 수
	public int groupcount(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		int groupcount = admindao.groupcount();
		return groupcount;
	}
	
	//파이 차트 주별 조회
	public List<PieChartDTO> weekPieChart(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		List<PieChartDTO> weekPieChart = admindao.weekPieChart();
		return weekPieChart;
	}
	//파이 차트 일별 조회
	public List<PieChartDTO> dailyPieChart(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		List<PieChartDTO> dailyPieChart = admindao.dailyPieChart();
		return dailyPieChart;
	}
	//파이 차트 월별 조회
	public List<PieChartDTO> monthPieChart(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		List<PieChartDTO> monthPieChart = admindao.monthPieChart();
		return monthPieChart;
	}
	
	//라인 차트 주별 조회
	public List<LineChartDTO> weeklyLineChart(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		List<LineChartDTO> weeklyLineChart = admindao.weeklyLineChart();
		return weeklyLineChart;
	}
	//라인 차트 일별 조회
	public List<LineChartDTO> dailyLineChart(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		List<LineChartDTO> dailyLineChart = admindao.dailyLineChart();
		return dailyLineChart;
	}
	//라인 차트 월별 조회
	public List<LineChartDTO> monthlyLineChart(){
		AdminDAO admindao = sqlsession.getMapper(AdminDAO.class);
		List<LineChartDTO> monthlyLineChart = admindao.monthlyLineChart();
		return monthlyLineChart;
	}
	
	
	
}
