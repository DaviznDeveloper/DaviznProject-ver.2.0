package kr.or.davizn.model.interfaces;

import java.util.List;

import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.UserStrgDTO;

public interface PersonalDataDAO {
	public int addPersonalData(PersonalDataDTO personaldto);
	public List<PersonalDataDTO> showPersonalDataList(int strgseq);
	
	//개인 데이터 추가하기
	/*public int addPersonalData(PersonalDataDTO pdata);*/
}
