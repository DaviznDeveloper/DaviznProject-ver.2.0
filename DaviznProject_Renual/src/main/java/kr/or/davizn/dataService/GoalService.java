package kr.or.davizn.dataService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.dataDTO.GoalListDTO;
import kr.or.davizn.dataDTO.NewGoal;
import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataDTO.PersonalDataGoalDTO;
import kr.or.davizn.dataInterface.GoalDAO;

@Service
public class GoalService {
	
	@Autowired
	SqlSession sqlsession;
	
	//목표 데이터 상세보기
		public List<PersonalDataGoalDTO> detailGoal(int dataseq){
			GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
			List<PersonalDataGoalDTO> gdata = goaldao.detailGoal(dataseq);
			return gdata;
		}
		
		//상세 목표 데이터 상태 변경
		public int updateDetailGoalState(int detailgoalseq){
			GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
			int result = goaldao.updateDetailGoalState(detailgoalseq);
			return result;
		}
		
		public int updateDetailComment(String commentmsg, int detailgoalseq){
			GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
			int result = goaldao.updateDetailComment(commentmsg, detailgoalseq);
			return result;
		}
	
	
	
	
	
		/*
		 * 목표 저장하기
		 * 
		 * */
		public void addNewGoal(NewGoal newGoal, int strgseq) throws ParseException{
			
			GoalDAO dao = sqlsession.getMapper(GoalDAO.class);
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
					System.out.println(dto.getDetailcount());
					dto.setFinaldate(dao.getGoals(dataseq).getFinaldate());	
					dto.setGoalname(personalDatas.get(i).getDataname());
					dto.setGoalpercent(dao.getGoals(dataseq).getGoalpercent());
					goalList.add(dto);
				}
				
			}
			
			return goalList;
		}
}