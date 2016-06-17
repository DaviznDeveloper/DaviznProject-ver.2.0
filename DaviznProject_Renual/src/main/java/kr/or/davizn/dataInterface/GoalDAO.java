package kr.or.davizn.dataInterface;

import java.util.List;

import kr.or.davizn.dataDTO.PersonalDataGoalDTO;

public interface GoalDAO {
	
	//상세 목표 데이터 보기
	public List<PersonalDataGoalDTO> detailGoal(int dataseq);
	
	//상세 목표의 상태 변경(0(not check)->1(check))
	public int updateDetailGoalState(int detailgoalseq);
	
	//상세 목표의 달성 메세지 변경
	public int updateDetailComment(String commentmsg, int detailgoalseq);
	
}
