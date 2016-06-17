package kr.or.davizn.dataService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
