package kr.or.davizn.dataInterface;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import kr.or.davizn.dataDTO.AlarmDTO;

public interface AlramDAO {
	//알람 갯수
	public int getCount(String userid) throws ClassNotFoundException, SQLException;
	//스케줄이용  goal 알람 넣기
	public void goalAlarm() throws ClassNotFoundException, SQLException;
	//스케줄 이용 스케줄 알림 넣기
	public void scheduelAlarm() throws ClassNotFoundException, SQLException;	
	//전체 게시물
	public List<AlarmDTO> getAlarm(Principal userid) throws ClassNotFoundException, SQLException;
	//전체 삭제 
	public int deleteAlarm() throws ClassNotFoundException, SQLException;
	//읽은 알람 삭제
	public int selectAlarm(int checkedstate) throws ClassNotFoundException, SQLException;
	//사용자의 알람 데이터 보여주기
	public List<AlarmDTO> showAlarmList(String userid);
}
