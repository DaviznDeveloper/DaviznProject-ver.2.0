package kr.or.davizn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.UserStrgDTO;
import kr.or.davizn.model.interfaces.PersonalDataDAO;
import kr.or.davizn.model.interfaces.UserStrgDAO;

@Service
public class PersonalData {
	@Autowired
	SqlSession sqlsession;
	
	
	//저장소 리스트 출력
	public List<PersonalDataDTO> showPersonalDataList(int strgseq){
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		List<PersonalDataDTO> result = dao.showPersonalDataList(strgseq);
		return result;
	}
}
