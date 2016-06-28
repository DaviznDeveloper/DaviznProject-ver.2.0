package kr.or.davizn.datainfoInterface;

import java.util.List;

import kr.or.davizn.datainfoDTO.GroupDataDTO;
import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;

public interface GroupDataDAO {
	
	//최근에 추가한 데이터 g_dataseq 가져오기
	public int getG_dataseq(int groupseq);
	public int updateGroupdata(GroupDataDTO groupdatadto);
	public int addGroupDataTable(GroupDataDTO groupdatadto);
	public int deleteGroupDataTable(int dataseq);
	public GroupDataDTO getOneGroupData(int dataseq);
	public List<GroupDataDTO> getG_ShareDatalist(int groupseq);
	
}
