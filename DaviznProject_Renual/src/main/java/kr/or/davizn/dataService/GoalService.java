package kr.or.davizn.dataService;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.dataDTO.GoalDTO;
import kr.or.davizn.dataDTO.GoalListDTO;
import kr.or.davizn.dataDTO.NewGoal;
import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataInterface.GoalDAO;

@Service
public class GoalService {
	
	@Autowired
	SqlSession sqlsession;
	
	
	
	/*
	 * 목표 저장하기
	 * 
	 * */
	public void addNewGoal(NewGoal newGoal, int strgseq) throws ParseException{
		
		GoalDAO dao = sqlsession.getMapper(GoalDAO.class);
		String newstartdate = newGoal.getStartdate().replace(" AM", "");
		newGoal.setStartdate(newstartdate);
	
		String finalstartdate = newGoal.getFinaldate().replace(" AM", "");
		newGoal.setFinaldate(finalstartdate);
		
		
		dao.addPdata(strgseq, newGoal.getDataname());
		dao.addGoal(newGoal.getStartdate(), newGoal.getFinaldate());
		for(String goalname:newGoal.getDetailnames()){	
			dao.addDetailGoal(goalname);
		}
	}

	
	
	/*
	 * 큰 목표 리스트
	 *
	 * */
	public List<GoalListDTO> showGoalList(int strgseq){
		
		GoalDAO dao = sqlsession.getMapper(GoalDAO.class);
		List<GoalListDTO> goalList = new ArrayList<GoalListDTO>();
		List<PersonalDataDTO> personalDatas = dao.getPersonalDatas(strgseq);
	
		
		int pDataSize = personalDatas.size();
		System.out.println("List Service에 들어옴 ");
		System.out.println("personalData 사이즈는 : "+pDataSize);
	
		if(personalDatas.size() < 0){
			return null;
		}
		else{
			System.out.println("else문 들어옴");
			for(int i=0; i < pDataSize; i++){
				System.out.println(i+"번째 personal dataseq : "+personalDatas.get(i).getDataseq());
				GoalListDTO dto = new GoalListDTO();
				int dataseq = personalDatas.get(i).getDataseq();
				
				
				
				dto.setDataseq(dataseq);
				
				dto.setDetailcount(dao.getDetailGoalCounts(dataseq));
				
				dto.setFinaldate(dao.getGoals(dataseq).getFinaldate());
				
				dto.setGoalname(personalDatas.get(i).getDataname());
				
				dto.setGoalpercent(dao.getGoals(dataseq).getGoalpercent());
				/*System.out.println("dataseq : " + dto.getDataseq());
				System.out.println("detail count : " + dto.getDetailcount());
				System.out.println("final date : " + dao.getGoals(dataseq).getFinaldate());
				*/
				/*dto.setFinaldate(goals.get(i).getFinaldate());
				dto.setGoalname(personalDatas.get(i).getDataname());
				dto.setGoalpercent(goals.get(i).getGoalpercent());*/
				/*System.out.println("목표 번호 : "+dto.getDataseq());
				System.out.println("세부 목표 갯수 : "+dto.getDetailcount());
				System.out.println("목표 종료 날짜 : "+dto.getFinaldate());
				System.out.println("목표 이름 : "+dto.getGoalname());
				System.out.println("목표 달성량 : "+dto.getGoalpercent());*/
				System.out.println("add 성공 여부"+goalList.add(dto));
			}
			
		}
		
		return goalList;
	}

}
