package kr.or.davizn.groupService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.groupDTO.GroupMemberDTO;
import kr.or.davizn.groupInterface.GroupInfoDAO;
import kr.or.davizn.groupInterface.GroupMemberDAO;

@Service
public class GroupMemberService {
	
	@Autowired
	SqlSession sqlsession;

	public void addGroupMember(GroupMemberDTO groupMemberDTO){
		GroupMemberDAO groupMemberdao = sqlsession.getMapper(GroupMemberDAO.class);
		groupMemberdao.addGroupMember(groupMemberDTO);
	}
	
	public List<GroupMemberDTO> getMemberlis(int groupseq){
		GroupMemberDAO groupMemberdao = sqlsession.getMapper(GroupMemberDAO.class);
		return groupMemberdao.getMemberlist(groupseq);
	}
}
