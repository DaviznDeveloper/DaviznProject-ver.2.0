package kr.or.davizn.datasetInterface;


import java.util.List;

import kr.or.davizn.datasetDTO.NewGoalDTO;
import kr.or.davizn.datasetDTO.PersonalDataGoalDTO;

public interface GoalDAO {
   
	
   /* 큰 목표 추가
    * addPdata(); PersonalData 테이블에 insert
    * addGoal(); Goal 테이블에 insert
    * addDetailGoal(); detailGoal 테이블에 insert
    * */
   public int addGoal(NewGoalDTO newgoal);
   public int addDetailGoal(String goalname);
	
	/* 큰 목표 리스트
	 * getPersonalDatas(); 데이터 고유번호, 큰 목표 이름 가져오기 위해 PersonalDataDTO 가져오기
	 * getGoals(); 종료날짜, 달성량을 가져오기 위해 GoalDTO 가져오기
	 * getDetailGoalCounts(); 세부 목표 갯수 구하기
	 * 각각의 값들을 가져와서 service에서 새로운 dto에 넣을 예정
	 * */	
   	public List<PersonalDataGoalDTO> getGoalList(int strgseq);
	public int getDetailGoalCounts(int strgseq);
	
	//상세 목표 데이터 보기
	public List<PersonalDataGoalDTO> detailGoal(int dataseq);
	
	//상세 목표의 상태 변경(0(not check)->1(check))
	public int updateDetailGoalState(int detailgoalseq);
	
	//상세 목표의 달성 메세지 변경
	public int updateDetailComment(String commentmsg, int detailgoalseq);
	
	//상세 화면에서 달성 퍼센트 변경
	public int updateGoalPercent(int dataseq);


	
}


	

