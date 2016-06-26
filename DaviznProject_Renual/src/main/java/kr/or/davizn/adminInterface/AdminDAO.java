package kr.or.davizn.adminInterface;

import java.util.List;

import kr.or.davizn.adminDTO.LineChartDTO;
import kr.or.davizn.adminDTO.PieChartDTO;

public interface AdminDAO {
	
	//총 회원의 수
	public int membercount();
	//회원이 생성한 데이터의 수
	public int datacount();
	//회원이 생성한 그룹의 수
	public int groupcount();
	
	//파이 차트 주별 조회
	public List<PieChartDTO> weekPieChart();
	//파이 차트 일별 조회
	public List<PieChartDTO> dailyPieChart();
	//파이 차트 월별 조회
	public List<PieChartDTO> monthPieChart();
	
	//라인 차트 일별 조회
	public List<LineChartDTO> dailyLineChart();
	//라인 차트 주별 조회
	public List<LineChartDTO> weeklyLineChart();
	//라인 차트 월별 조회
	public List<LineChartDTO> monthlyLineChart();
}
