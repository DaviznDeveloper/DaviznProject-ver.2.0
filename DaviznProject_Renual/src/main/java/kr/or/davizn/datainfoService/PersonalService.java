package kr.or.davizn.datainfoService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datainfoInterface.PersonalDataDAO;

@Service
public class PersonalService {
	@Autowired
	SqlSession sqlsession;

	// 방금 추가한 개인데이터의 dataseq 가져오기
	public int getDataseq(int strgseq) {
		PersonalDataDAO personalDAO = sqlsession.getMapper(PersonalDataDAO.class);
		int dataseq = personalDAO.getDataseq(strgseq);
		return dataseq;
	}

	// 데이터 저장. personaldata 테이블에 저장하기.
	public int addPersonalData(PersonalDataDTO personaldto) {
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		int result = dao.addPersonalData(personaldto);
		return result;
	}
	
	// 데이터 리스트 출력
	public List<PersonalDataDTO> showPersonalDataList(int strgseq) {
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		List<PersonalDataDTO> result = dao.showPersonalDataList(strgseq);
		return result;
	}

	// 개인데이터 수정
	public int updatePersonaldata(int dataseq, String dataname) {
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		int result = dao.updatePersonaldata(dataname, dataseq);
		return result;
	}
	//개인 데이터 삭제
	public void deletePersonalData(int dataseq){
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		dao.deletePersonalData(dataseq);
	}

}
