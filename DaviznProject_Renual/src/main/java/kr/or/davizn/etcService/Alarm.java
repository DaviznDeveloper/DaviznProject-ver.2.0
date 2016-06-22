package kr.or.davizn.etcService;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.or.davizn.dataDTO.AlarmDTO;
import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataInterface.AlramDAO;

@Service
public class Alarm {
	@Autowired
	SqlSession sqlsession;


	// goal 알람
	public void insertAlram() throws Exception {

		AlramDAO AlramDao = sqlsession.getMapper(AlramDAO.class);
		AlramDao.goalAlarm();
		
	
	}
	
	//scheduelAlarm 알람
	public void insertscheduel() throws Exception{
		AlramDAO AlramDao=sqlsession.getMapper(AlramDAO.class);
		AlramDao.scheduelAlarm();
	}
	

	
	//header에 알람 정보 뿌리기
	public List<AlarmDTO> showAlarmList(String userid,Model model){
		System.out.println("알람 서비스");
		AlramDAO AlramDao=sqlsession.getMapper(AlramDAO.class);
		List<AlarmDTO> alramList = AlramDao.showAlarmList(userid);
		model.addAttribute("userid",userid);
		System.out.println(alramList);
		return alramList;
		
	}
	
	//알람 개수
	public int getCount(String userid) throws Exception{
		AlramDAO alramDao = sqlsession.getMapper(AlramDAO.class);
		return alramDao.getCount(userid);
	}
}
