package kr.or.davizn.dataInterface;


import java.util.List;

import kr.or.davizn.dataDTO.GoalDTO;
import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataDTO.PersonalDataGoalDTO;

public interface GoalDAO {
   
   /* 큰 목표 추가
    * addPdata(); PersonalData 테이블에 insert
    * addGoal(); Goal 테이블에 insert
    * addDetailGoal(); detailGoal 테이블에 insert
    * */
   public int addPdata(int strgseq, String dataname);
   public int addGoal(String startdate, String finaldate);
   public int addDetailGoal(String goalname);
	
	/* 큰 목표 리스트
	 * getPersonalDatas(); 데이터 고유번호, 큰 목표 이름 가져오기 위해 PersonalDataDTO 가져오기
	 * getGoals(); 종료날짜, 달성량을 가져오기 위해 GoalDTO 가져오기
	 * getDetailGoalCounts(); 세부 목표 갯수 구하기
	 * 각각의 값들을 가져와서 service에서 새로운 dto에 넣을 예정
	 * */
	public List<PersonalDataDTO> getPersonalDatas(int strgseq);
	public GoalDTO getGoals(int dataseq);
	public int getDetailGoalCounts(int strgseq);
	
	//상세 목표 데이터 보기
	public List<PersonalDataGoalDTO> detailGoal(int dataseq);
	
	//상세 목표의 상태 변경(0(not check)->1(check))
	public int updateDetailGoalState(int detailgoalseq);
	
	//상세 목표의 달성 메세지 변경
	public int updateDetailComment(String commentmsg, int detailgoalseq);
	
	//상세 화면에서 달성 퍼센트 변경
	public int updateGoalPercent(int dataseq);
	
	//목표 데이터 삭제
	public int deleteGoal(int dataseq);

	
}


	

