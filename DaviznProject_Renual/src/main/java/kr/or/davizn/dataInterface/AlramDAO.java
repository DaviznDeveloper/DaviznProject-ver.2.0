package kr.or.davizn.dataInterface;

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
	//사용자의 알람 데이터 보여주기
	public List<AlarmDTO> showAlarmList(String userid);
	//알람 읽음 표시
	public void increseAlarm(int alarmseq) throws ClassNotFoundException, SQLException;
	//알람 전체 페이지 보기
	public List<AlarmDTO> alarmList(String userid) throws ClassNotFoundException, SQLException;
	//읽은 알람 삭제
	public int deleteRead(String userid) throws ClassNotFoundException, SQLException;
	//한개 항목 삭제
	public int deleteOne(int alarmseq);
	//알람 전체 삭제
	public int deleteAll(String userid);
	
}
