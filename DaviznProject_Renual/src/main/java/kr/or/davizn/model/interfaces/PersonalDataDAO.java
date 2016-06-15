package kr.or.davizn.model.interfaces;

import java.util.List;

import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.UserStrgDTO;

public interface PersonalDataDAO {
	//개인 데이터 추가하기
	public int addPersonalData(PersonalDataDTO personaldto);
	//개인 데이터 리스트 보기
	public List<PersonalDataDTO> showPersonalDataList(int strgseq);
	//개인 데이터 수정
	public int deletePersonalData(int dataseq);
	
}
