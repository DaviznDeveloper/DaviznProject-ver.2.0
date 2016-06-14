package kr.or.davizn.model.interfaces;

import java.util.List;

import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.UserStrgDTO;

public interface PersonalDataDAO {
	
	public List<PersonalDataDTO> showPersonalDataList(int strgseq);
}
