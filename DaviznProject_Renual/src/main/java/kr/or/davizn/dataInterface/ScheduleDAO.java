package kr.or.davizn.dataInterface;

import java.util.List;

import kr.or.davizn.dataDTO.PersonaldataSchDTO;
import kr.or.davizn.dataDTO.ScheduleDTO;

public interface ScheduleDAO {
	
	//개인 저장소에 일정 데이터 추가하기
	public int createPersonalData(int strgseq, String dataname);
	
	//일정 데이터 추가하기
	public int createSchedule(ScheduleDTO schedule);
	
	//현재 진행 중인 일정 리스트
	public List<PersonaldataSchDTO> currentSchedule(int strgseq);
	//종료한 일정 리스트
	public List<PersonaldataSchDTO> endSchedule(int strgseq);
	
	//일정 상세보기
	public PersonaldataSchDTO detailSchedule(int dataseq);
	
	//일정 삭제하기
	public int deleteSchedule(int dataseq);
	
	//일정(개인데이터) 수정하기
	public int updatePersonalDate(String dataname, int dataseq);
	
	//일정 수정하기
	public int updateSchedule(ScheduleDTO schedule);
}
