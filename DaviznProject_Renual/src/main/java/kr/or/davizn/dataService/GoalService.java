package kr.or.davizn.dataService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.davizn.dataDTO.GoalListDTO;
import kr.or.davizn.dataDTO.NewGoal;
import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataDTO.PersonalDataGoalDTO;
import kr.or.davizn.dataInterface.GoalDAO;

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
	
	//목표 데이터 삭제
	public int deleteGoal(int dataseq){
		GoalDAO goaldao = sqlsession.getMapper(GoalDAO.class);
		int result = goaldao.deleteGoal(dataseq);
		return result;
	}

	
	
	/*
	 * 목표 저장하기
	 * 
	 */
	@Transactional
	public void addNewGoal(NewGoal newGoal, int strgseq) throws ParseException {

		GoalDAO dao = sqlsession.getMapper(GoalDAO.class);
		dao.addPdata(strgseq, newGoal.getDataname());
		dao.addGoal(newGoal.getStartdate(), newGoal.getFinaldate());
		for (String goalname : newGoal.getDetailnames()) {
			dao.addDetailGoal(goalname);
		}
	}
	

	
	
	/*
	 * 큰 목표 리스트
	 *
	 */
	@Transactional
	public List<GoalListDTO> showGoalList(int strgseq) {

		GoalDAO dao = sqlsession.getMapper(GoalDAO.class);
		List<GoalListDTO> goalList = new ArrayList<GoalListDTO>();
		List<PersonalDataDTO> personalDatas = dao.getPersonalDatas(strgseq);

		int pDataSize = personalDatas.size();
		if (personalDatas.size() < 0) {
			return null;
		} else {
			for (int i = 0; i < pDataSize; i++) {
				GoalListDTO dto = new GoalListDTO();
				int dataseq = personalDatas.get(i).getDataseq();
				dto.setDataseq(dataseq);
				dto.setDetailcount(dao.getDetailGoalCounts(dataseq));
				dto.setFinaldate(dao.getGoals(dataseq).getFinaldate());
				dto.setGoalname(personalDatas.get(i).getDataname());
				dto.setGoalpercent(dao.getGoals(dataseq).getGoalpercent());
				goalList.add(dto);
			}
		}
		return goalList;
	}
}
