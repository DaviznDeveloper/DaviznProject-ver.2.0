package kr.or.davizn.datainfoInterface;

import java.util.List;

import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datasetDTO.NewGoalDTO;

public interface PersonalDataDAO {
	
	//방금 추가한 데이터 고유번호(dataseq) 가져오기
	public int getDataseq(int strgseq);
	//개인 데이터 추가하기
	public int addPersonalData(PersonalDataDTO personaldto);
	//개인 데이터 리스트 보기
	public List<PersonalDataDTO> showPersonalDataList(int strgseq);
	//개인 데이터 삭제
	public int deletePersonalData(int dataseq);
	//개인 데이터 수정(update)
	public int updatePersonaldata(String dataname,int dataseq);
	
}
