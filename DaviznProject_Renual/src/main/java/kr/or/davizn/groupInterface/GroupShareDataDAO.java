package kr.or.davizn.groupInterface;

import java.util.List;

import kr.or.davizn.groupDTO.GroupShareDataDTO;

public interface GroupShareDataDAO {
	
	//데이터 공유하기
	public int addShareData(GroupShareDataDTO groupsharedto);
	//공유된 데이터 목록 출력하기
	public List<GroupShareDataDTO> showShareDataList(int groupseq);
}
