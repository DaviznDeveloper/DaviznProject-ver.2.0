package kr.or.davizn.groupInterface;

import java.util.List;

import kr.or.davizn.groupDTO.GroupInfoDTO;

public interface GroupInfoDAO {

	public int addGroup(GroupInfoDTO groupInfoDTO);
	
	//public int deleteGroup();
	//public int updateGroup();
	
	//그룹 랜덤으로 5개 가져오기
	public List<GroupInfoDTO> randomGroupList();
	
	//검색한 그룹 리스트 가져오기
	public List<GroupInfoDTO> searchGroupList(String keyword);
}
