package kr.or.davizn.dataInterface;

import java.sql.Date;
import java.util.List;

import kr.or.davizn.dataDTO.GoalDTO;
import kr.or.davizn.dataDTO.PersonalDataDTO;

public interface GoalDAO {
	
	/* 큰 목표 추가
	 * addPdata(); PersonalData 테이블에 insert
	 * addGoal(); Goal 테이블에 insert
	 * addDetailGoal(); detailGoal 테이블에 insert
	 * */
	public int addPdata(int strgseq, String dataname);
	public int addGoal(String startdate, String finaldate);
	public int addDetailGoal(String goalname);
	//큰 목표 삭제
	
	//큰 목표 수정
	
	
	
	
	/* 큰 목표 리스트
	 * getPersonalDatas(); 데이터 고유번호, 큰 목표 이름 가져오기 위해 PersonalDataDTO 가져오기
	 * getGoals(); 종료날짜, 달성량을 가져오기 위해 GoalDTO 가져오기
	 * getDetailGoalCounts(); 세부 목표 갯수 구하기
	 * 각각의 값들을 가져와서 service에서 새로운 dto에 넣을 예정
	 * */
	public List<PersonalDataDTO> getPersonalDatas(int strgseq);
	public GoalDTO getGoals(int dataseq);
	public int getDetailGoalCounts(int strgseq);
	
	

	
}
