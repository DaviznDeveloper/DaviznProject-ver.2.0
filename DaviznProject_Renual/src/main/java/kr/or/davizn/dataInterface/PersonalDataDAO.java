package kr.or.davizn.dataInterface;

import java.util.List;

import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataDTO.UserStrgDTO;

public interface PersonalDataDAO {
	//개인 데이터 추가하기
	public int addPersonalData(PersonalDataDTO personaldto);
	//개인 데이터 리스트 보기
	public List<PersonalDataDTO> showPersonalDataList(int strgseq);
	//개인 데이터 수정(기존 정보 확인)
	public int deletePersonalData(int dataseq);
	//개인 데이터 수정(update)
	public int updatePersonaldata(String dataname,int dataseq);
	
}
