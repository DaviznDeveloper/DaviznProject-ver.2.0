package kr.or.davizn.datasetService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datainfoInterface.PersonalDataDAO;
import kr.or.davizn.datasetDTO.NewGoalDTO;
import kr.or.davizn.datasetDTO.PersonalDataGoalDTO;
import kr.or.davizn.datasetInterface.GoalDAO;

@Service
public class GoalService {

   @Autowired
   SqlSession sqlsession;

   // 목표 데이터 상세보기
   public List<PersonalDataGoalDTO> detailGoal(int dataseq) {
      GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
      List<PersonalDataGoalDTO> gdata = goaldao.detailGoal(dataseq);
      return gdata;
   }


	// 상세 목표 데이터 상태 변경	
	public int updateDetailGoalState(int detailgoalseq) {
		GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
		int result = goaldao.updateDetailGoalState(detailgoalseq);
		return result;
	}
	
	//상세화면에서 달성 퍼센트 변경
	public int updateGoalPercent(int dataseq){
		GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
		int result = goaldao.updateGoalPercent(dataseq);
		return result;
	}
	
	//상세 수정
	public int updateDetailComment(String commentmsg, int detailgoalseq) {
		GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
		int result = goaldao.updateDetailComment(commentmsg, detailgoalseq);
		return result;
	}


   /*
    * 목표 저장하기
    * 
    */
   @Transactional
   public void addNewGoal(NewGoalDTO newGoal) throws ParseException {
		GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
		goaldao.addGoal(newGoal);
		for (String goalname : newGoal.getDetailnames()) {
			goaldao.addDetailGoal(goalname);
		}
	}
	 
   /*
    * 큰 목표 리스트
    *
    */
   @Transactional
   public List<PersonalDataGoalDTO> showGoalList(int strgseq) {
      GoalDAO dao = sqlsession.getMapper(GoalDAO.class);
      List<PersonalDataGoalDTO> goalList = dao.getGoalList(strgseq);
      for(PersonalDataGoalDTO dto:goalList){
    	  int detailcount = dao.getDetailGoalCounts(dto.getDataseq());
    	  dto.setDetailcount(detailcount);
      }
      return goalList;
   }
}