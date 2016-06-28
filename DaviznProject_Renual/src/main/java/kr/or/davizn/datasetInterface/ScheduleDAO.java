package kr.or.davizn.datasetInterface;

import java.util.List;

import kr.or.davizn.datasetDTO.PersonaldataSchDTO;

public interface ScheduleDAO {
	
	
	//일정 데이터 추가하기
	public int createSchedule(PersonaldataSchDTO schedule);
	
	//현재 진행 중인 일정 리스트
	public List<PersonaldataSchDTO> currentSchedule(int strgseq);
	//종료한 일정 리스트
	public List<PersonaldataSchDTO> endSchedule(int strgseq);
	
	//일정 상세보기
	public PersonaldataSchDTO detailSchedule(int dataseq);
	

	//일정 수정하기
	public int updateSchedule(PersonaldataSchDTO schedule);
}
