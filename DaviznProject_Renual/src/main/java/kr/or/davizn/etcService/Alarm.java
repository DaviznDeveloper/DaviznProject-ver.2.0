package kr.or.davizn.etcService;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.or.davizn.dataDTO.AlarmDTO;
import kr.or.davizn.dataInterface.AlramDAO;

@Service
public class Alarm {
	@Autowired
	SqlSession sqlsession;


	// goal 알람
	public void insertAlram() throws Exception {
		System.out.println("1번");
		AlramDAO AlramDao = sqlsession.getMapper(AlramDAO.class);
		AlramDao.goalAlarm();
	}
	
	//scheduelAlarm 알람
	public void insertscheduel() throws Exception{
		System.out.println("2번");
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
	
	//알람 읽음 표시 
	public void readAlarm(int alarmseq) throws ClassNotFoundException, SQLException{
		AlramDAO alramDao = sqlsession.getMapper(AlramDAO.class);
		alramDao.increseAlarm(alarmseq);
	}
	
	//알람 전체 페이지 보기
	public List<AlarmDTO> alarmList(Principal userid,Model model) throws ClassNotFoundException, SQLException{
		System.out.println("리스트 탓음");
		AlramDAO alramDao = sqlsession.getMapper(AlramDAO.class);
		List<AlarmDTO> list=alramDao.alarmList(userid.getName());
		model.addAttribute("list",list);
		System.out.println("list"+list);
		return list;
	}
	
	//알람 한개만 삭제
	public int deleteOne(int alarmseq){
		AlramDAO alramDao = sqlsession.getMapper(AlramDAO.class);
		int result=alramDao.deleteOne(alarmseq);
		return result;
	}
	
	//알람 전체 삭제
	public int allDelete (Principal userid) throws ClassNotFoundException, SQLException{
		AlramDAO alramDao = sqlsession.getMapper(AlramDAO.class);
		int reuslt=alramDao.deleteAll(userid.getName());
		return reuslt;
	}
	
	//읽은 알람 삭제
	public int readThings (Principal userid) throws ClassNotFoundException, SQLException{
		AlramDAO alramDao = sqlsession.getMapper(AlramDAO.class);
		int reuslt=alramDao.deleteRead(userid.getName());
		return reuslt;
	}
	
	//알람 증가
	public void stateUp (int alarmseq) throws ClassNotFoundException, SQLException{
		AlramDAO alramDao = sqlsession.getMapper(AlramDAO.class);
		alramDao.increseAlarm(alarmseq);
		
	}
}
