package kr.or.davizn.datasetService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.datasetDTO.PersonaldataSchDTO;
import kr.or.davizn.datasetInterface.ScheduleDAO;

@Service
public class ScheduleService {
	
	@Autowired
	SqlSession sqlsession;
	
	//일정 데이터 추가하기
	public int addSchedule(PersonaldataSchDTO schedule){
		ScheduleDAO schdao = sqlsession.getMapper(ScheduleDAO.class);
		int sresult = schdao.createSchedule(schedule);
		return sresult;
		
	}
	
	//현재 진행 중인 리스트 보기
	public List<PersonaldataSchDTO> currentSchedule(int strgseq){
		ScheduleDAO schdao = sqlsession.getMapper(ScheduleDAO.class);
		List<PersonaldataSchDTO> clist = schdao.currentSchedule(strgseq);
		return clist;
	}
	//종료한 일정 리스트 보기
	public List<PersonaldataSchDTO> endSchedule(int strgseq){
		ScheduleDAO schdao = sqlsession.getMapper(ScheduleDAO.class);
		List<PersonaldataSchDTO> elist = schdao.endSchedule(strgseq);
		return elist;
		
	}
	
	//상세 일정 보기
	public PersonaldataSchDTO detailSchedule(int dataseq){
		ScheduleDAO schdao = sqlsession.getMapper(ScheduleDAO.class);
		PersonaldataSchDTO schedule = schdao.detailSchedule(dataseq);
		return schedule;
	}
	

	//일정 수정하기
	@Transactional
	public int updateSchedule(PersonaldataSchDTO schedule){
		ScheduleDAO schdao = sqlsession.getMapper(ScheduleDAO.class);
		int sresult = schdao.updateSchedule(schedule);
		return sresult;
	}
	
}
