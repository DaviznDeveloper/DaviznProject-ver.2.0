package kr.or.davizn.groupInterface;

import java.util.List;

import kr.or.davizn.groupDTO.GroupMemberDTO;

public interface GroupMemberDAO {
	public void addGroupMember(GroupMemberDTO groupmemberdto);
	public List<GroupMemberDTO> getMemberlist(int groupseq);
}
